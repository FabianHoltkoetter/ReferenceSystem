package integration;

import edu.hm.ba.kongo.shop.ordering.service.gen.services.businessactions.TestDatenBusinessActionService;
import edu.hm.ba.kongo.shop.ordering.service.rest.OrderingItem_Repository;
import org.junit.After;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

/**
 * Created by Fabian on 14.02.2017.
 */
public class TestDatenBusinessActionServiceTest extends OrderingServiceBaseTest{

    @Autowired
    TestDatenBusinessActionService service;
    @Autowired
    OrderingItem_Repository repository;

    @After
    public void deleteTestData(){
        repository.deleteAll();
    }

    @Test
    public void testdatenErzeugenTest(){
        service.testdatenErzeugen();
        assertEquals(repository.count(), 1);
    }
}
