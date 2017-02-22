package edu.hm.ba.kongo.shop.ordering.service.test.unit;

import edu.hm.ba.kongo.shop.shoppingcart.service.gen.domain.CartItem_;
import edu.hm.ba.kongo.shop.shoppingcart.service.gen.domain.Cart_;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashSet;
import java.util.UUID;

import static org.junit.Assert.*;

/**
 * Created by Fabian on 15.02.2017.
 */
public class CartTest {

    private Cart_ cart_;
    private Cart_ cart_1;
    private Cart_ cart_2;
    private Cart_ cart_3;
    private final CartItem_ cartItem_;

    public CartTest(){
        cartItem_ = new CartItem_();
        cartItem_.setProduct("123");
        cartItem_.setQuantity(1);

        UUID id1 = UUID.fromString("12341234-1212-1212-1212-123456123456");
        UUID id2 = UUID.fromString("12341234-1212-1212-1212-123456123455");

        cart_ = new Cart_();
        cart_.setItems(new HashSet<>(Collections.singletonList(cartItem_)));
        cart_.setUserID("123");
        cart_.setTotalPrice(new BigDecimal(15.5));
        cart_.setOid(id1);

        cart_1 = new Cart_();
        cart_1.setItems(new HashSet<>(Collections.singletonList(cartItem_)));
        cart_1.setUserID("123");
        cart_1.setTotalPrice(new BigDecimal(15.5));
        cart_1.setOid(id1);

        cart_2 = new Cart_();
        cart_2.setItems(new HashSet<>(Collections.singletonList(cartItem_)));
        cart_2.setUserID("123");
        cart_2.setTotalPrice(new BigDecimal(15.5));
        cart_2.setOid(id2);

        cart_3 = new Cart_();
    }

    @Test
    public void equalsTest(){
        assertTrue(cart_.equals(cart_1));
        cart_1.setTotalPrice(null);
        assertFalse(cart_.equals(cart_1));
        cart_1.setTotalPrice(new BigDecimal(15.5));
        cart_1.setUserID(null);
        assertFalse(cart_.equals(cart_1));
        cart_1.setUserID("123");
        cart_1.setItems(null);
        assertFalse(cart_.equals(cart_1));
        cart_.setItems(new HashSet<>(Collections.singletonList(cartItem_)));
        assertFalse(cart_.equals(null));
        assertFalse(cart_.equals("test"));
        assertFalse(cart_.equals(cart_2));
        assertFalse(cart_.equals(cart_3));
    }

    @Test
    public void hashcodeTest(){
        assertEquals(cart_.hashCode(), cart_1.hashCode());
        assertNotEquals(cart_.hashCode(), cart_2.hashCode());
        assertNotEquals(cart_.hashCode(), cart_3.hashCode());
    }
}
