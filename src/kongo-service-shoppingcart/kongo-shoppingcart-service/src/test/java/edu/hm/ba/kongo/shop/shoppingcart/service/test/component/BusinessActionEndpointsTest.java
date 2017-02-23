package edu.hm.ba.kongo.shop.shoppingcart.service.test.component;

import edu.hm.ba.kongo.shop.shoppingcart.service.test.integration.OrderingServiceBaseTest;
import edu.hm.ba.kongo.shop.shoppingcart.service.rest.Cart_Repository;
import org.hamcrest.core.StringEndsWith;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.oauth2.common.util.Jackson2JsonParser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by Fabian on 19.02.2017.
 */
public class BusinessActionEndpointsTest extends OrderingServiceBaseTest{

    @Autowired
    Cart_Repository repository;
    @Autowired
    WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;
    private Jackson2JsonParser parser = new Jackson2JsonParser();

    @After
    public void deleteTestData(){
        repository.deleteAll();
    }

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void beansExist(){
        assertNotNull(repository);
        assertNotNull(webApplicationContext);
    }

    @Test
    public void linksAvailableTest() throws Exception {
        mockMvc.perform(get("/businessActions"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/hal+json"))
                .andExpect(jsonPath("$._links.self.href").value(StringEndsWith.endsWith("businessActions")))
                .andExpect(jsonPath("$._links.testdatenErzeugen.href").value(StringEndsWith.endsWith("businessActions/testdatenErzeugen")))
                .andExpect(jsonPath("$._links.addToCart.href").value(StringEndsWith.endsWith("businessActions/addToCart")));

    }

    @Test
    public void testDatenEndpointTest() throws Exception {
        mockMvc.perform(get("/businessActions/testdatenErzeugen"))
                .andExpect(status().isOk());
        assertEquals(repository.count(), 1);
    }

    @Test
    public void orderCartEndpointTest() throws Exception {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("productID", "123");
        parameters.put("quantity", "1");

        mockMvc.perform(get("/businessActions/addToCart"))
                .andExpect(status().isMethodNotAllowed());
        mockMvc.perform(post("/businessActions/addToCart"))
                .andExpect(status().isBadRequest());
        mockMvc.perform(post("/businessActions/addToCart")
                        .content(parser.formatMap(parameters))
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isInternalServerError());
    }
}
