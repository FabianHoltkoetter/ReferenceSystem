package edu.hm.ba.kongo.shop.ordering.service.test.integration;

import com.google.common.collect.Iterables;
import edu.hm.ba.kongo.shop.ordering.service.gen.domain.OrderingItem_;
import edu.hm.ba.kongo.shop.ordering.service.gen.services.businessactions.TestDatenBusinessActionService;
import edu.hm.ba.kongo.shop.ordering.service.rest.OrderingItem_Repository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Fabian on 14.02.2017.
 */
public class OrderingItem_RepositoryTest extends OrderingServiceBaseTest {

    @Autowired
    OrderingItem_Repository repository;
    @Autowired
    TestDatenBusinessActionService service;

    @Before
    public void initializeTestData(){
        service.testdatenErzeugen();
    }

    @After
    public void deleteTestData(){
        repository.deleteAll();
    }

    @Test
    public void beansExistAndTestDataAvailable(){
        assertNotNull(repository);
        assertNotNull(service);
        assertEquals(repository.count(), 1);
    }

    @Test
    public void findAllTest() {
        Iterable<OrderingItem_> all = repository.findAll();
        assertEquals(Iterables.size(all), 1);
        OrderingItem_ order = all.iterator().next();
        assertEquals(order.getCart(), "123");
        assertEquals(order.getOrderedOn(), LocalDate.parse("10.10.2010", DateTimeFormatter.ofPattern("dd.MM.yyyy")));
    }

    @Test
    public void findOneTest(){
        UUID oid = repository.findAll().iterator().next().getOid();
        OrderingItem_ order = repository.findOne(oid);
        assertEquals(order.getCart(), "123");
        assertEquals(order.getOrderedOn(), LocalDate.parse("10.10.2010", DateTimeFormatter.ofPattern("dd.MM.yyyy")));
    }

    @Test
    public void saveTest(){
        repository.deleteAll();
        OrderingItem_ order = new OrderingItem_();
        order.setCart("123");
        order.setOrderedOn(LocalDate.parse("10.10.2010", DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        repository.save(order);
        assertEquals(repository.count(), 1);
    }

    @Test
    public void deleteTest(){
        UUID oid = repository.findAll().iterator().next().getOid();
        repository.delete(oid);
        assertEquals(repository.count(), 0);
        assertFalse(repository.exists(oid));
    }

    @Test
    public void deleteEntityTest(){
        UUID oid = repository.findAll().iterator().next().getOid();

        OrderingItem_ order = new OrderingItem_();
        order.setCart("123");
        order.setOrderedOn(LocalDate.parse("10.10.2010", DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        order.setOid(oid);
        repository.delete(order);

        assertEquals(repository.count(), 0);
        assertFalse(repository.exists(oid));
    }

    @Test
    public void deleteAllTest(){
        repository.deleteAll();
        assertEquals(repository.count(), 0);
    }

    @Test
    public void findByCartTest(){
        OrderingItem_ order = repository.findByCart("123").iterator().next();
        assertNotNull(order);
        assertEquals(order.getOrderedOn(), LocalDate.parse("10.10.2010", DateTimeFormatter.ofPattern("dd.MM.yyyy")));
    }

    @Test
    public void findByOrderedOnTest(){
        OrderingItem_ order = repository.findByOrderedOn(LocalDate.parse("10.10.2010", DateTimeFormatter.ofPattern("dd.MM.yyyy"))).iterator().next();
        assertNotNull(order);
        assertEquals(order.getCart(), "123");
    }
}
