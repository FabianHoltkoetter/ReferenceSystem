package edu.hm.ba.kongo.shop.ordering.service.test.unit;

import edu.hm.ba.kongo.shop.shoppingcart.service.gen.domain.CartItem_;
import edu.hm.ba.kongo.shop.shoppingcart.service.gen.domain.Cart_;
import edu.hm.ba.kongo.shop.shoppingcart.service.gen.services.event.Cart_EventService;
import edu.hm.ba.kongo.shop.shoppingcart.service.services.event.Cart_EventServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

/**
 * Created by Fabian Wilms on 25.01.2017.
 */
public class Cart_EventServiceImplTest {

    private Cart_ cart_;
    Cart_EventService cart_eventService= new Cart_EventServiceImpl();
    private UUID uuid = UUID.fromString("12341234-1212-1212-1212-123456123456");
    private String userID = "123";
    private BigDecimal totalPrice = new BigDecimal(15.5);
    private Set<CartItem_> cartItemSet;

    @Before
    public void setup(){
        CartItem_ cartItem_ = new CartItem_();
        cartItem_.setProduct("123");
        cartItem_.setQuantity(1);

        cartItemSet = new HashSet<>(Collections.singletonList(cartItem_));
        cart_ = new Cart_();
        cart_.setItems(cartItemSet);
        cart_.setUserID(userID);
        cart_.setTotalPrice(totalPrice);
        cart_.setOid(uuid);
    }

    @Test
    public void onAfterCreateTest(){
        cart_eventService.onAfterCreate(cart_);

        assertEquals(cart_.getUserID(), userID);
        assertEquals(cart_.getItems(), cartItemSet);
        assertEquals(cart_.getTotalPrice(), totalPrice);
        assertEquals(cart_.getOid(), uuid);
    }

    @Test
    public void onBeforeCreateTest(){
        cart_eventService.onBeforeCreate(cart_);

        assertEquals(cart_.getUserID(), userID);
        assertEquals(cart_.getItems(), cartItemSet);
        assertEquals(cart_.getTotalPrice(), totalPrice);
        assertEquals(cart_.getOid(), uuid);
    }

    @Test
    public void onAfterSaveTest(){
        cart_eventService.onAfterSave(cart_);

        assertEquals(cart_.getUserID(), userID);
        assertEquals(cart_.getItems(), cartItemSet);
        assertEquals(cart_.getTotalPrice(), totalPrice);
        assertEquals(cart_.getOid(), uuid);
    }

    @Test
    public void onBeforeSaveTest(){
        cart_eventService.onBeforeSave(cart_);

        assertEquals(cart_.getUserID(), userID);
        assertEquals(cart_.getItems(), cartItemSet);
        assertEquals(cart_.getTotalPrice(), totalPrice);
        assertEquals(cart_.getOid(), uuid);
    }

    @Test
    public void onAfterLinkSaveTest(){
        String anotherObject = "test";

        cart_eventService.onAfterLinkSave(cart_, anotherObject);

        assertEquals(cart_.getUserID(), userID);
        assertEquals(cart_.getItems(), cartItemSet);
        assertEquals(cart_.getTotalPrice(), totalPrice);
        assertEquals(cart_.getOid(), uuid);
    }

    @Test
    public void onBeforeLinkSaveTest(){
        String anotherObject = "test";

        cart_eventService.onBeforeLinkDelete(cart_, anotherObject);

        assertEquals(cart_.getUserID(), userID);
        assertEquals(cart_.getItems(), cartItemSet);
        assertEquals(cart_.getTotalPrice(), totalPrice);
        assertEquals(cart_.getOid(), uuid);
    }

    @Test
    public void onAfterLinkDeleteTest(){
        String anotherObject = "test";

        cart_eventService.onAfterLinkDelete(cart_, anotherObject);

        assertEquals(cart_.getUserID(), userID);
        assertEquals(cart_.getItems(), cartItemSet);
        assertEquals(cart_.getTotalPrice(), totalPrice);
        assertEquals(cart_.getOid(), uuid);
    }

    @Test
    public void onBeforeLinkDeleteTest(){
        String anotherObject = "test";

        cart_eventService.onBeforeLinkDelete(cart_, anotherObject);

        assertEquals(cart_.getUserID(), userID);
        assertEquals(cart_.getItems(), cartItemSet);
        assertEquals(cart_.getTotalPrice(), totalPrice);
        assertEquals(cart_.getOid(), uuid);
    }

    @Test
    public void onAfterDeleteTest(){
        cart_eventService.onAfterDelete(cart_);

        assertEquals(cart_.getUserID(), userID);
        assertEquals(cart_.getItems(), cartItemSet);
        assertEquals(cart_.getTotalPrice(), totalPrice);
        assertEquals(cart_.getOid(), uuid);
    }

    @Test
    public void onBeforeDelete(){
        cart_eventService.onBeforeDelete(cart_);

        assertEquals(cart_.getUserID(), userID);
        assertEquals(cart_.getItems(), cartItemSet);
        assertEquals(cart_.getTotalPrice(), totalPrice);
        assertEquals(cart_.getOid(), uuid);
    }

}
