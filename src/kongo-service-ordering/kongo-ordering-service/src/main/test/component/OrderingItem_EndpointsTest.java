package component;

import edu.hm.ba.kongo.shop.ordering.service.gen.domain.OrderingItem_;
import edu.hm.ba.kongo.shop.ordering.service.gen.services.businessactions.TestDatenBusinessActionService;
import edu.hm.ba.kongo.shop.ordering.service.rest.OrderingItem_Repository;
import integration.OrderingServiceBaseTest;
import org.apache.commons.collections.SetUtils;
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
public class OrderingItem_EndpointsTest extends OrderingServiceBaseTest {

    @Autowired
    private TestDatenBusinessActionService testDatenBusinessActionService;
    @Autowired
    OrderingItem_Repository repository;
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
        mockMvc.perform(get("/orderingItems"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/hal+json"))
                .andExpect(jsonPath("$._embedded.orderingItems[0].cart").value("123"))
                .andExpect(jsonPath("$._embedded.orderingItems[0].orderedOn").value("2010-10-10"))
                .andExpect(jsonPath("$._embedded.orderingItems[0]._links.self").exists())
                .andExpect(jsonPath("$._embedded.orderingItems[0]._links.orderingItem_").exists())
                .andExpect(jsonPath("$._links.self.href").value(StringEndsWith.endsWith("orderingItems")))
                .andExpect(jsonPath("$._links.profile.href").value(StringEndsWith.endsWith("profile/orderingItems")))
                .andExpect(jsonPath("$._links.search.href").value(StringEndsWith.endsWith("orderingItems/search")));
    }

    @Test
    public void deleteTest() throws Exception{
        UUID oid = repository.findAll().iterator().next().getOid();
        mockMvc.perform(delete("/orderingItems/" + oid.toString()))
                .andExpect(status().isNoContent());
        assertEquals(repository.count(), 0L);
    }

    @Test
    public void postTest() throws Exception{

        HashMap<String, String> orderingItem = new HashMap<>();
        orderingItem.put("cart", "123");
        orderingItem.put("orderedOn", "2010-10-10");

        Jackson2JsonParser parser = new Jackson2JsonParser();
        String body = parser.formatMap(orderingItem);

        mockMvc.perform(post("/orderingItems")
                        .content(body))
                .andExpect(status().isCreated())
                .andExpect(content().contentType("application/hal+json"))
                .andExpect(jsonPath("$.cart").value("123"))
                .andExpect(jsonPath("$.orderedOn").value("2010-10-10"));
    }

}
