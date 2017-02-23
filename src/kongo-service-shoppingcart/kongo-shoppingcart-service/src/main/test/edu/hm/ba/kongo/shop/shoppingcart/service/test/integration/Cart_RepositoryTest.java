package edu.hm.ba.kongo.shop.shoppingcart.service.test.integration;

import com.google.common.collect.Iterables;
import edu.hm.ba.kongo.shop.shoppingcart.service.gen.domain.CartItem_;
import edu.hm.ba.kongo.shop.shoppingcart.service.gen.domain.Cart_;
import edu.hm.ba.kongo.shop.shoppingcart.service.gen.services.businessactions.TestDatenBusinessActionService;
import edu.hm.ba.kongo.shop.shoppingcart.service.rest.Cart_Repository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Fabian on 14.02.2017.
 */
public class Cart_RepositoryTest extends OrderingServiceBaseTest {

    @Autowired
    Cart_Repository repository;
    @Autowired
    TestDatenBusinessActionService service;
    private final Set<CartItem_> cartItemSet;

    @Before
    public void initializeTestData(){
        service.testdatenErzeugen();
    }

    @After
    public void deleteTestData(){
        repository.deleteAll();
    }

    public Cart_RepositoryTest(){
        CartItem_ cartItem_ = new CartItem_();
        cartItem_.setProduct("123");
        cartItem_.setQuantity(1);

        cartItemSet = new HashSet<>(Collections.singletonList(cartItem_));
    }

    @Test
    public void beansExistAndTestDataAvailable(){
        assertNotNull(repository);
        assertNotNull(service);
        assertEquals(repository.count(), 1);
    }

    @Test
    public void findAllTest() {
        Iterable<Cart_> all = repository.findAll();
        assertEquals(Iterables.size(all), 1);
        Cart_ cart_ = all.iterator().next();

        assertEquals("123", cart_.getUserID());
        assertEquals(cartItemSet, cart_.getItems());
        assertEquals(new BigDecimal(15.5), cart_.getTotalPrice().stripTrailingZeros());
    }

    @Test
    public void findOneTest(){
        UUID oid = repository.findAll().iterator().next().getOid();
        Cart_ cart_ = repository.findOne(oid);

        assertEquals("123", cart_.getUserID());
        assertEquals(cartItemSet, cart_.getItems());
        assertEquals(new BigDecimal(15.5), cart_.getTotalPrice().stripTrailingZeros());}

    @Test
    public void saveTest(){
        repository.deleteAll();
        Cart_ cart_ = new Cart_();
        cart_.setUserID("123");
        cart_.setTotalPrice(new BigDecimal(15.5));
        cart_.setItems(cartItemSet);
        repository.save(cart_);
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

        Cart_ cart_ = new Cart_();
        cart_.setUserID("123");
        cart_.setTotalPrice(new BigDecimal(15.5));
        cart_.setItems(cartItemSet);
        cart_.setOid(oid);
        repository.delete(cart_);

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
        Cart_ cart_ = repository.findByUserID("123").iterator().next();

        assertNotNull(cart_);
        assertEquals(cartItemSet, cart_.getItems());
        assertEquals(new BigDecimal(15.5), cart_.getTotalPrice().stripTrailingZeros());
    }

    @Test
    public void findByOrderedOnTest(){
        Cart_ cart_ = repository.findByTotalPrice(new BigDecimal(15.5)).iterator().next();
        assertNotNull(cart_);
        assertEquals(cart_.getUserID(), "123");
        assertEquals(cart_.getItems(), cartItemSet);
    }
}
