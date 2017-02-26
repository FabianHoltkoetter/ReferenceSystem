package edu.hm.ba.kongo.shop.shoppingcart.service.test.integration;

import edu.hm.ba.kongo.shop.shoppingcart.service.gen.services.businessactions.TestDatenBusinessActionService;
import edu.hm.ba.kongo.shop.shoppingcart.service.rest.Cart_Repository;
import org.junit.After;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

/**
 * @author Fabian Holtkötter
 * Tests the correctness of the testDatenErzeugen-BusinessAction on which some of the tests rely on.
 */
public class TestDatenBusinessActionServiceTest extends CartServiceBaseTest {

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
