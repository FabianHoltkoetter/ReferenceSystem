package edu.hm.ba.kongo.shop.ordering.service.test.integration;

import edu.hm.ba.kongo.shop.ordering.service.test.utils.TestAuthenticationProvider;
import edu.hm.ba.kongo.shop.shoppingcart.service.gen.businessActionParams.AddToCart_BusinessActionParameters;
import edu.hm.ba.kongo.shop.shoppingcart.service.gen.controller.businessactions.BusinessActionController;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Integration Tests for the BusinnesActionController. Checks
 */
public class BusinessActionControllerTest extends OrderingServiceBaseTest {

    @Autowired
    BusinessActionController businessActionController;

    @Test
    public void beanExists(){
        assertNotNull(businessActionController);
    }

    @Test
    public void getMethodActionsTest(){
        List<Link> methodActions = businessActionController.getMethodActions();
        Set<String> collect = methodActions.stream().map(Link::getRel).collect(Collectors.toSet());
        assertTrue(collect.containsAll(Arrays.asList("testdatenErzeugen", "addToCart")));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void orderCartTest(){
        AddToCart_BusinessActionParameters parameters = new AddToCart_BusinessActionParameters();
        parameters.setProductID("123");
        parameters.setQuantity(1L);
        businessActionController.addToCart(null, null, parameters);
    }

    @Test(expected = AccessDeniedException.class)
    public void orderCartAuthenticationTest(){
        SecurityContext context = SecurityContextHolder.getContext();
        context.setAuthentication(TestAuthenticationProvider.getTestAuthenticationWithSpecific(AuthorityUtils.createAuthorityList("none")));

        AddToCart_BusinessActionParameters parameters = new AddToCart_BusinessActionParameters();
        parameters.setProductID("123");
        parameters.setQuantity(1L);
        businessActionController.addToCart(null, null, parameters);
    }
}
