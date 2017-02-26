package edu.hm.ba.kongo.shop.shoppingcart.service.test.unit;

import edu.hm.ba.kongo.shop.shoppingcart.service.gen.services.businessactions.AddToCart_BusinessActionService;
import edu.hm.ba.kongo.shop.shoppingcart.service.services.businessactions.AddToCart_BusinessActionServiceImpl;
import org.junit.Test;

/**
 * @author Fabian Holtkötter
 * Test-Class to ensure the correctness of the BusinessAction AddToCart_
 */
public class AddToCart_BusinessActionServiceImplTest {

    private AddToCart_BusinessActionService businessActionService = new AddToCart_BusinessActionServiceImpl();

    @Test(expected = IllegalArgumentException.class)
    public void cancelOrderIllegalArgumentsTest(){
        businessActionService.addToCart(null, null, null);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void cancelOrderUnsupportedTest(){
        businessActionService.addToCart(null, "1234-5678-9123", 1L);
    }

}
