package edu.hm.ba.kongo.shop.ordering.service.test.unit;

import edu.hm.ba.kongo.shop.ordering.service.gen.domain.OrderingItem_;
import edu.hm.ba.kongo.shop.ordering.service.gen.services.event.OrderingItem_EventService;
import edu.hm.ba.kongo.shop.ordering.service.services.event.OrderingItem_EventServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

/**
 * @author Fabian Holtkötter
 * Tests that validate the correctness of the EventService implementations. The EventServices always use copy by value.
 */
public class OrderingItem_EventServiceImplTest {


    OrderingItem_EventService order_eventService = new OrderingItem_EventServiceImpl();

    private OrderingItem_ order_;
    private String cart = "testcart";
    private LocalDate orderdOn = LocalDate.of(2010, 10, 10);

    @Before
    public void setup(){
        order_ = new OrderingItem_();
        order_.setCart(cart);
        order_.setOrderedOn(orderdOn);
    }

    @Test
    public void onAfterCreateTest(){
        order_eventService.onAfterCreate(order_);

        assertEquals(order_.getCart(), cart);
        assertEquals(order_.getOrderedOn(), orderdOn);
    }

    @Test
    public void onBeforeCreateTest(){
        order_eventService.onBeforeCreate(order_);

        assertEquals(order_.getCart(), cart);
        assertEquals(order_.getOrderedOn(), orderdOn);
    }

    @Test
    public void onAfterSaveTest(){
        order_eventService.onAfterSave(order_);

        assertEquals(order_.getCart(), cart);
        assertEquals(order_.getOrderedOn(), orderdOn);
    }

    @Test
    public void onBeforeSaveTest(){
        order_eventService.onBeforeSave(order_);

        assertEquals(order_.getCart(), cart);
        assertEquals(order_.getOrderedOn(), orderdOn);
    }

    @Test
    public void onAfterLinkSaveTest(){
        String anotherObject = "test";

        order_eventService.onAfterLinkSave(order_, anotherObject);

        assertEquals(order_.getCart(), cart);
        assertEquals(order_.getOrderedOn(), orderdOn);
    }

    @Test
    public void onBeforeLinkSaveTest(){
        String anotherObject = "test";

        order_eventService.onBeforeLinkDelete(order_, anotherObject);

        assertEquals(order_.getCart(), cart);
        assertEquals(order_.getOrderedOn(), orderdOn);
    }

    @Test
    public void onAfterLinkDeleteTest(){
        String anotherObject = "test";

        order_eventService.onAfterLinkDelete(order_, anotherObject);

        assertEquals(order_.getCart(), cart);
        assertEquals(order_.getOrderedOn(), orderdOn);
    }

    @Test
    public void onBeforeLinkDeleteTest(){
        String anotherObject = "test";

        order_eventService.onBeforeLinkDelete(order_, anotherObject);

        assertEquals(order_.getCart(), cart);
        assertEquals(order_.getOrderedOn(), orderdOn);
    }

    @Test
    public void onAfterDeleteTest(){
        String anotherObject = "test";

        order_eventService.onAfterDelete(order_);

        assertEquals(order_.getCart(), cart);
        assertEquals(order_.getOrderedOn(), orderdOn);
    }

    @Test
    public void onBeforeDelete(){
        String anotherObject = "test";

        order_eventService.onBeforeDelete(order_);

        assertEquals(order_.getCart(), cart);
        assertEquals(order_.getOrderedOn(), orderdOn);
    }

}
