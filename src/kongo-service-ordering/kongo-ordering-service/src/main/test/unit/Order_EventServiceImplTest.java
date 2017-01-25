package unit;

import edu.hm.ba.kongo.shop.ordering.service.gen.domain.Order_;
import edu.hm.ba.kongo.shop.ordering.service.gen.services.event.Order_EventService;
import edu.hm.ba.kongo.shop.ordering.service.services.event.Order_EventServiceImpl;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

/**
 * Created by Fabian on 25.01.2017.
 */
public class Order_EventServiceImplTest {


    Order_EventService order_eventService = new Order_EventServiceImpl();

    @Test
    public void onAfterCreateTest(){
        Order_ order_ = new Order_();
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
        Order_ order_ = new Order_();
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
        Order_ order_ = new Order_();
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
        Order_ order_ = new Order_();
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
        Order_ order_ = new Order_();
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
        Order_ order_ = new Order_();
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
        Order_ order_ = new Order_();
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
        Order_ order_ = new Order_();
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
        Order_ order_ = new Order_();
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
        Order_ order_ = new Order_();
        String cart = "testcart";
        LocalDate orderdOn = LocalDate.of(2010, 10, 10);
        order_.setCart(cart);
        order_.setOrderedOn(orderdOn);

        order_eventService.onBeforeDelete(order_);

        assertEquals(order_.getCart(), cart);
        assertEquals(order_.getOrderedOn(), orderdOn);
    }

}
