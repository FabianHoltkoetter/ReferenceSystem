package edu.hm.ba.kongo.shop.shoppingcart.service.test.integration;

import edu.hm.ba.kongo.shop.shoppingcart.service.gen.services.businessactions.TestDatenBusinessActionService;
import edu.hm.ba.kongo.shop.shoppingcart.service.rest.Cart_Repository;
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
    Cart_Repository repository;

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
