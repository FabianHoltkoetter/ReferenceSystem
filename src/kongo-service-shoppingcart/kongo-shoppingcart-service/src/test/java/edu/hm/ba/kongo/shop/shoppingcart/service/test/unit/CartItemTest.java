package edu.hm.ba.kongo.shop.shoppingcart.service.test.unit;

import edu.hm.ba.kongo.shop.shoppingcart.service.gen.domain.CartItem_;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Fabian Holtkötter
 * Validates the correctness of equals- and hashcode-Methods on the entity CartItem_
 */
public class CartItemTest {

    private CartItem_ cartItem_;
    private CartItem_ cartItem_1;
    private CartItem_ cartItem_2;

    public CartItemTest(){

        cartItem_ = new CartItem_();

        cartItem_.setProduct("123");
        cartItem_.setQuantity(1);

        cartItem_1 = new CartItem_();
        cartItem_1.setProduct("123");
        cartItem_1.setQuantity(1);

        cartItem_2 = new CartItem_();
    }

    @Test
    public void equalsTest(){
        assertTrue(cartItem_.equals(cartItem_1));
        cartItem_1.setProduct(null);
        assertFalse(cartItem_.equals(cartItem_1));
        cartItem_1.setProduct("123");
        assertFalse(cartItem_.equals(null));
        assertFalse(cartItem_.equals("test"));
        assertFalse(cartItem_.equals(cartItem_2));
    }

    @Test
    public void hashcodeTest(){
        assertEquals(cartItem_.hashCode(), cartItem_1.hashCode());
        assertNotEquals(cartItem_.hashCode(), cartItem_2.hashCode());
    }
}
