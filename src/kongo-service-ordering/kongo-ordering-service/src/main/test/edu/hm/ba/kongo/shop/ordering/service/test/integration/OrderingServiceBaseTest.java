package edu.hm.ba.kongo.shop.ordering.service.test.integration;

import edu.hm.ba.kongo.shop.ordering.service.MicroServiceApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import edu.hm.ba.kongo.shop.ordering.service.test.utils.TestAuthenticationProvider;

/**
 * Created by Fabian Wilms on 11.02.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MicroServiceApplication.class)
@WebAppConfiguration
public class OrderingServiceBaseTest {

    /**
     * Injects a test authentication object into springs security context.
     */
    @Before
    public void authenticateUser(){
        SecurityContext context = SecurityContextHolder.getContext();
        context.setAuthentication(TestAuthenticationProvider.getTestAuthenticationWithAll());
    }

    @Test
    public void contextLoads(){

    }
}
