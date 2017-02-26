package edu.hm.ba.kongo.shop.shoppingcart.service.test.integration;

import edu.hm.ba.kongo.shop.shoppingcart.service.MicroServiceApplication;
import edu.hm.ba.kongo.shop.shoppingcart.service.test.utils.TestAuthenticationProvider;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author Fabian Holtkötter
 * Base-Class to be used by integration and component-tests. This class allows the spring environment to start and the service to get tested.
 * Also this base class injects a mocked authentication to be used by following tests.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MicroServiceApplication.class)
@WebAppConfiguration
public class CartServiceBaseTest {

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
