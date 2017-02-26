package edu.hm.ba.kongo.shop.ordering.service.test.unit;

import edu.hm.ba.kongo.shop.ordering.service.gen.services.businessactions.SendInvoice_BusinessActionService;
import edu.hm.ba.kongo.shop.ordering.service.services.businessactions.SendInvoice_BusinessActionServiceImpl;
import org.junit.Test;

/**
 * @author Fabian Holtkötter
 * Test-Class to ensure the correctness of the BusinessAction SendInvoice_
 */
public class SendInvoice_BusinessActionServiceImplTest {

    SendInvoice_BusinessActionService baImpl = new SendInvoice_BusinessActionServiceImpl();

    @Test(expected = IllegalArgumentException.class)
    public void sendInvoiceIllegalArgumentsTest(){
        baImpl.sendInvoice(null, null);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void sendInvoiceUnsupportedTest(){
        baImpl.sendInvoice(null, "1234-5678-9123");
    }
}
