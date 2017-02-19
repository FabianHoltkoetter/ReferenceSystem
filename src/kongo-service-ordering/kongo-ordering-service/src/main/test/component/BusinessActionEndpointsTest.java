package component;

import edu.hm.ba.kongo.shop.ordering.service.gen.services.businessactions.TestDatenBusinessActionService;
import edu.hm.ba.kongo.shop.ordering.service.rest.OrderingItem_Repository;
import integration.OrderingServiceBaseTest;
import org.hamcrest.core.StringEndsWith;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.oauth2.common.util.Jackson2JsonParser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.util.NestedServletException;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Fabian on 19.02.2017.
 */
public class BusinessActionEndpointsTest extends OrderingServiceBaseTest{

    @Autowired
    OrderingItem_Repository repository;
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
                .andExpect(jsonPath("$._links.orderCart.href").value(StringEndsWith.endsWith("businessActions/orderCart")))
                .andExpect(jsonPath("$._links.sendInvoice.href").value(StringEndsWith.endsWith("businessActions/sendInvoice")))
                .andExpect(jsonPath("$._links.cancelOrder.href").value(StringEndsWith.endsWith("businessActions/cancelOrder")));

    }

    @Test
    public void testDatenEndpointTest() throws Exception {
        mockMvc.perform(get("/businessActions/testdatenErzeugen"))
                .andExpect(status().isOk());
    }

    @Test(expected = NestedServletException.class)
    public void orderCartEndpointTest() throws Exception {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("cartID", "123");

        String contentAsString = mockMvc.perform(get("/businessActions")).andReturn().getResponse().getContentAsString();
        Map<String, Object> stringObjectMap = parser.parseMap(contentAsString);


        mockMvc.perform(get("/businessActions/orderCart"))
                .andExpect(status().isMethodNotAllowed());
        mockMvc.perform(post("/businessActions/orderCart"))
                .andExpect(status().isBadRequest());
        mockMvc.perform(post("/businessActions/orderCart")
                        .content(parser.formatMap(parameters))
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isInternalServerError())
                .andExpect(jsonPath("$.exception").value("java.lang.UnsupportedOperationException"));
    }

    @Test(expected = NestedServletException.class)
    public void sendInvoiceTest() throws Exception {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("orderID", "123");

        mockMvc.perform(get("/businessActions/sendInvoice"))
                .andExpect(status().isMethodNotAllowed());
        mockMvc.perform(post("/businessActions/sendInvoice"))
                .andExpect(status().isBadRequest());
        mockMvc.perform(post("/businessActions/sendInvoice")
                        .content(parser.formatMap(parameters))
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isInternalServerError())
                .andExpect(jsonPath("$.exception").value("java.lang.UnsupportedOperationException"));
    }

    @Test(expected = NestedServletException.class)
    public void cancelOrderTest() throws Exception {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("orderID", "123");

        mockMvc.perform(get("/businessActions/cancelOrder"))
                .andExpect(status().isMethodNotAllowed());
        mockMvc.perform(post("/businessActions/cancelOrder"))
                .andExpect(status().isBadRequest());
        mockMvc.perform(post("/businessActions/cancelOrder")
                        .content(parser.formatMap(parameters))
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isInternalServerError())
                .andExpect(jsonPath("$.exception").value("java.lang.UnsupportedOperationException"));

    }
}
