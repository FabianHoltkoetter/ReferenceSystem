package unit;

import edu.hm.ba.kongo.shop.ordering.service.gen.domain.OrderingItem_;
import edu.hm.ba.kongo.shop.ordering.service.gen.services.event.OrderingItem_EventService;
import edu.hm.ba.kongo.shop.ordering.service.services.event.OrderingItem_EventServiceImpl;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

/**
 * Created by Fabian Wilms on 25.01.2017.
 */
public class Order_EventServiceImplTest {


    OrderingItem_EventService order_eventService = new OrderingItem_EventServiceImpl();

    @Test
    public void onAfterCreateTest(){
        OrderingItem_ order_ = new OrderingItem_();
        String cart = "testcart";
        LocalDate orderdOn = LocalDate.of(2010, 10, 10);
        order_.setCart(cart);
        order_.setOrderedOn(orderdOn);

        order_eventService.onAfterCreate(order_);

        assertEquals(order_.getCart(), cart);
        assertEquals(order_.getOrderedOn(), orderdOn);
    }

    @Test
    public void onBeforeCreateTest(){
        OrderingItem_ order_ = new OrderingItem_();
        String cart = "testcart";
        LocalDate orderdOn = LocalDate.of(2010, 10, 10);
        order_.setCart(cart);
        order_.setOrderedOn(orderdOn);

        order_eventService.onBeforeCreate(order_);

        assertEquals(order_.getCart(), cart);
        assertEquals(order_.getOrderedOn(), orderdOn);
    }

    @Test
    public void onAfterSaveTest(){
        OrderingItem_ order_ = new OrderingItem_();
        String cart = "testcart";
        LocalDate orderdOn = LocalDate.of(2010, 10, 10);
        order_.setCart(cart);
        order_.setOrderedOn(orderdOn);

        order_eventService.onAfterSave(order_);

        assertEquals(order_.getCart(), cart);
        assertEquals(order_.getOrderedOn(), orderdOn);
    }

    @Test
    public void onBeforeSaveTest(){
        OrderingItem_ order_ = new OrderingItem_();
        String cart = "testcart";
        LocalDate orderdOn = LocalDate.of(2010, 10, 10);
        order_.setCart(cart);
        order_.setOrderedOn(orderdOn);

        order_eventService.onBeforeSave(order_);

        assertEquals(order_.getCart(), cart);
        assertEquals(order_.getOrderedOn(), orderdOn);
    }

    @Test
    public void onAfterLinkSaveTest(){
        OrderingItem_ order_ = new OrderingItem_();
        String cart = "testcart";
        LocalDate orderdOn = LocalDate.of(2010, 10, 10);
        String anotherObject = "test";
        order_.setCart(cart);
        order_.setOrderedOn(orderdOn);

        order_eventService.onAfterLinkSave(order_, anotherObject);

        assertEquals(order_.getCart(), cart);
        assertEquals(order_.getOrderedOn(), orderdOn);
    }

    @Test
    public void onBeforeLinkSaveTest(){
        OrderingItem_ order_ = new OrderingItem_();
        String cart = "testcart";
        LocalDate orderdOn = LocalDate.of(2010, 10, 10);
        String anotherObject = "test";
        order_.setCart(cart);
        order_.setOrderedOn(orderdOn);

        order_eventService.onBeforeLinkDelete(order_, anotherObject);

        assertEquals(order_.getCart(), cart);
        assertEquals(order_.getOrderedOn(), orderdOn);
    }

    @Test
    public void onAfterLinkDeleteTest(){
        OrderingItem_ order_ = new OrderingItem_();
        String cart = "testcart";
        LocalDate orderdOn = LocalDate.of(2010, 10, 10);
        String anotherObject = "test";
        order_.setCart(cart);
        order_.setOrderedOn(orderdOn);

        order_eventService.onAfterLinkDelete(order_, anotherObject);

        assertEquals(order_.getCart(), cart);
        assertEquals(order_.getOrderedOn(), orderdOn);
    }

    @Test
    public void onBeforeLinkDeleteTest(){
        OrderingItem_ order_ = new OrderingItem_();
        String cart = "testcart";
        LocalDate orderdOn = LocalDate.of(2010, 10, 10);
        String anotherObject = "test";
        order_.setCart(cart);
        order_.setOrderedOn(orderdOn);

        order_eventService.onBeforeLinkDelete(order_, anotherObject);

        assertEquals(order_.getCart(), cart);
        assertEquals(order_.getOrderedOn(), orderdOn);
    }

    @Test
    public void onAfterDeleteTest(){
        OrderingItem_ order_ = new OrderingItem_();
        String cart = "testcart";
        LocalDate orderdOn = LocalDate.of(2010, 10, 10);
        order_.setCart(cart);
        order_.setOrderedOn(orderdOn);

        order_eventService.onAfterDelete(order_);

        assertEquals(order_.getCart(), cart);
        assertEquals(order_.getOrderedOn(), orderdOn);
    }

    @Test
    public void onBeforeDelete(){
        OrderingItem_ order_ = new OrderingItem_();
        String cart = "testcart";
        LocalDate orderdOn = LocalDate.of(2010, 10, 10);
        order_.setCart(cart);
        order_.setOrderedOn(orderdOn);

        order_eventService.onBeforeDelete(order_);

        assertEquals(order_.getCart(), cart);
        assertEquals(order_.getOrderedOn(), orderdOn);
    }

}
