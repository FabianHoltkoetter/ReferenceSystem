package edu.hm.ba.kongo.shop.ordering.service.test.unit;

import edu.hm.ba.kongo.shop.ordering.service.gen.domain.OrderingItem_;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import static org.junit.Assert.*;

/**
 * Created by Fabian on 15.02.2017.
 */
public class OrderingItemTest {

    private OrderingItem_ item_;
    private OrderingItem_ item_1;
    private OrderingItem_ item_2;
    private OrderingItem_ item_3;

    public OrderingItemTest(){
        UUID id1 = UUID.fromString("12341234-1212-1212-1212-123456123456");
        UUID id2 = UUID.fromString("12341234-1212-1212-1212-123456123455");

        item_ = new OrderingItem_();
        item_.setCart("123");
        item_.setOrderedOn(LocalDate.parse("10.10.2010", DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        item_.setOid(id1);

        item_1 = new OrderingItem_();
        item_1.setCart("123");
        item_1.setOrderedOn(LocalDate.parse("10.10.2010", DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        item_1.setOid(id1);

        item_2 = new OrderingItem_();
        item_2.setCart("123");
        item_2.setOrderedOn(LocalDate.parse("10.10.2010", DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        item_2.setOid(id2);

        item_3 = new OrderingItem_();
    }

    @Test
    public void equalsTest(){
        assertTrue(item_.equals(item_1));
        item_1.setCart(null);
        assertFalse(item_.equals(item_1));
        item_1.setCart("123");
        item_1.setOrderedOn(null);
        assertFalse(item_.equals(item_1));
        item_1.setOrderedOn(LocalDate.parse("10.10.2010", DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        assertFalse(item_.equals(null));
        assertFalse(item_.equals("test"));
        assertFalse(item_.equals(item_2));
        assertFalse(item_.equals(item_3));
    }

    @Test
    public void hashcodeTest(){
        assertEquals(item_.hashCode(), item_1.hashCode());
        assertNotEquals(item_.hashCode(), item_2.hashCode());
        assertNotEquals(item_.hashCode(), item_3.hashCode());
    }
}
