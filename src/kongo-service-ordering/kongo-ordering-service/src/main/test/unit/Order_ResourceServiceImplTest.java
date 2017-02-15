package unit;

import edu.hm.ba.kongo.shop.ordering.service.gen.domain.OrderingItem_;
import edu.hm.ba.kongo.shop.ordering.service.gen.services.resource.OrderingItem_ResourceService;
import edu.hm.ba.kongo.shop.ordering.service.services.resource.OrderingItem_ResourceServiceImpl;
import org.junit.Test;
import org.springframework.hateoas.Resource;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

/**
 * Created by Fabian Wilms on 25.01.2017.
 */
public class Order_ResourceServiceImplTest {

    OrderingItem_ResourceService order_resourceService = new OrderingItem_ResourceServiceImpl();

    @Test
    public void processTest(){
        OrderingItem_ order_ = new OrderingItem_();
        String cart = "testcart";
        LocalDate orderdOn = LocalDate.of(2010, 10, 10);
        order_.setCart(cart);
        order_.setOrderedOn(orderdOn);
        Resource<OrderingItem_> resource = new Resource(order_);

        Resource<OrderingItem_> process = order_resourceService.process(resource);

        assertEquals(process.getContent().getCart(), cart);
        assertEquals(process.getContent().getOrderedOn(), orderdOn);
    }
}
