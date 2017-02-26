package edu.hm.ba.kongo.shop.ordering.service.test.unit;

import edu.hm.ba.kongo.shop.ordering.service.gen.services.businessactions.CancelOrder_BusinessActionService;
import edu.hm.ba.kongo.shop.ordering.service.gen.services.businessactions.OrderCart_BusinessActionService;
import edu.hm.ba.kongo.shop.ordering.service.services.businessactions.CancelOrder_BusinessActionServiceImpl;
import edu.hm.ba.kongo.shop.ordering.service.services.businessactions.OrderCart_BusinessActionServiceImpl;
import org.junit.Test;

/**
 * @author Fabian Holtkötter
 * Test-Class to ensure the correctness of the BusinessAction OrderCart_
 */
public class OrderCart_BusinessActionServiceImplTest {

    OrderCart_BusinessActionService baImpl = new OrderCart_BusinessActionServiceImpl();

    @Test(expected = IllegalArgumentException.class)
    public void orderCartIllegalArgumentsTest(){
        baImpl.orderCart(null, null);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void orderCartUnsupportedTest(){
        baImpl.orderCart(null, "1234-5678-9123");
    }
}
