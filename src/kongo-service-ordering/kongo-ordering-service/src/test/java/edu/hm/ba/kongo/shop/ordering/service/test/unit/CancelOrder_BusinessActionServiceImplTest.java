package edu.hm.ba.kongo.shop.ordering.service.test.unit;

import edu.hm.ba.kongo.shop.ordering.service.gen.services.businessactions.CancelOrder_BusinessActionService;
import edu.hm.ba.kongo.shop.ordering.service.services.businessactions.CancelOrder_BusinessActionServiceImpl;
import org.junit.Test;

/**
 * @author Fabian Holtkötter
 * Test-Class to ensure the correctness of the BusinessAction CancelOrder_
 */
public class CancelOrder_BusinessActionServiceImplTest {

    CancelOrder_BusinessActionService baImpl = new CancelOrder_BusinessActionServiceImpl();

    @Test(expected = IllegalArgumentException.class)
    public void cancelOrderIllegalArgumentsTest(){
        baImpl.cancelOrder(null, null);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void cancelOrderUnsupportedTest(){
        baImpl.cancelOrder(null, "1234-5678-9123");
    }
}
