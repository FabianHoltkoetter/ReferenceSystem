package edu.hm.ba.kongo.shop.shoppingcart.service.test.component;

import edu.hm.ba.kongo.shop.shoppingcart.service.test.integration.OrderingServiceBaseTest;
import edu.hm.ba.kongo.shop.shoppingcart.service.gen.rest.search.Cart_SearchController;
import edu.hm.ba.kongo.shop.shoppingcart.service.gen.services.businessactions.TestDatenBusinessActionService;
import edu.hm.ba.kongo.shop.shoppingcart.service.rest.Cart_Repository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by Fabian on 13.02.2017.
 */
public class Cart_SearchControllerTest extends OrderingServiceBaseTest {

    @Autowired
    private Cart_SearchController searchController;
    @Autowired
    private TestDatenBusinessActionService testDatenBusinessActionService;
    @Autowired
    private Cart_Repository repository;
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void createTestData(){
        testDatenBusinessActionService.testdatenErzeugen();
    }

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @After
    public void clearDB(){
        repository.deleteAll();
    }

    @Test
    public void beanExists(){
        assertNotNull(searchController);
    }

    @Test
    public void findFullTextFuzzyTest() throws Exception {        
        mockMvc.perform(get("/carts/search/findFullTextFuzzy").param("q", "123"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/hal+json"))
                .andExpect(jsonPath("$._embedded.carts[0].totalPrice").value(15.5));
    }
}
