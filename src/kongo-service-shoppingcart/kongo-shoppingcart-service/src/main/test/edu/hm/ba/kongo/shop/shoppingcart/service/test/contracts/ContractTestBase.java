package edu.hm.ba.kongo.shop.shoppingcart.service.test.contracts;

import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import edu.hm.ba.kongo.shop.shoppingcart.service.test.utils.TestAuthenticationProvider;
import edu.hm.ba.kongo.shop.shoppingcart.service.MicroServiceApplication;
import edu.hm.ba.kongo.shop.shoppingcart.service.rest.Cart_Repository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by Fabian Wilms on 11.02.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MicroServiceApplication.class)
@WebAppConfiguration
public class ContractTestBase {

    @Autowired
    private WebApplicationContext applicationContext;
    @Autowired
    private Cart_Repository repository;

    private MockMvc mockMvc;

    /**
     * Setup for running springs consumer driven contract testing
     */
    @Before
    public void setup(){
        SecurityContext context = SecurityContextHolder.getContext();
        context.setAuthentication(TestAuthenticationProvider.getTestAuthenticationWithAll());

        mockMvc = MockMvcBuilders
                .webAppContextSetup(applicationContext)
                .build();
        RestAssuredMockMvc.mockMvc(mockMvc);


    }

    @Test
    public void contextStarts(){}

    public void isDataCreated(){
        assert repository.count() == 1;
    }
}
