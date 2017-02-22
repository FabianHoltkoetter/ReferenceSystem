package edu.hm.ba.kongo.shop.ordering.service.test.component;

import edu.hm.ba.kongo.shop.ordering.service.test.integration.OrderingServiceBaseTest;
import edu.hm.ba.kongo.shop.shoppingcart.service.gen.services.businessactions.TestDatenBusinessActionService;
import edu.hm.ba.kongo.shop.shoppingcart.service.rest.Cart_Repository;
import org.hamcrest.core.StringEndsWith;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.util.Jackson2JsonParser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Fabian on 19.02.2017.
 */
public class Cart_EndpointsTest extends OrderingServiceBaseTest {

    @Autowired
    private TestDatenBusinessActionService testDatenBusinessActionService;
    @Autowired
    Cart_Repository repository;
    @Autowired
    WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void createTestData(){
        testDatenBusinessActionService.testdatenErzeugen();
    }

    @After
    public void deleteTestData(){
        repository.deleteAll();
    }

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void beansExistAndTestDataAvailable(){
        assertNotNull(repository);
        assertNotNull(testDatenBusinessActionService);
        assertNotNull(webApplicationContext);
        assertEquals(repository.count(), 1);
    }

    @Test
    public void getTest() throws Exception {
        mockMvc.perform(get("/carts"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/hal+json"))
                .andExpect(jsonPath("$._embedded.carts[0].userID").value("123"))
                .andExpect(jsonPath("$._embedded.carts[0].totalPrice").value(15.5))
                .andExpect(jsonPath("$._embedded.carts[0]._links.self").exists())
                .andExpect(jsonPath("$._embedded.carts[0]._links.cart_").exists())
                .andExpect(jsonPath("$._links.self.href").value(StringEndsWith.endsWith("carts")))
                .andExpect(jsonPath("$._links.profile.href").value(StringEndsWith.endsWith("profile/carts")))
                .andExpect(jsonPath("$._links.search.href").value(StringEndsWith.endsWith("carts/search")));
    }

    @Test
    public void deleteTest() throws Exception{
        UUID oid = repository.findAll().iterator().next().getOid();
        mockMvc.perform(delete("/carts/" + oid.toString()))
                .andExpect(status().isNoContent());
        assertEquals(repository.count(), 0L);
    }

    @Test
    public void postTest() throws Exception{
        Jackson2JsonParser parser = new Jackson2JsonParser();

        HashMap<String, String> cartItem = new HashMap<>();
        cartItem.put("product", "123");
        cartItem.put("quantity", "1");

        HashMap<String, String> orderingItem = new HashMap<>();
        orderingItem.put("userID", "123");
        orderingItem.put("totalPrice", "15.5");
        orderingItem.put("items", "[" + parser.formatMap(cartItem) + "]");

        String body = parser.formatMap(orderingItem);

        mockMvc.perform(post("/carts")
                        .content(body))
                .andExpect(status().isCreated())
                .andExpect(content().contentType("application/hal+json"))
                .andExpect(jsonPath("$.userID").value("123"))
                .andExpect(jsonPath("$.totalPrice").value("15.5"));
    }

}
