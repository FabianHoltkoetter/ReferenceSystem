package unit;

import edu.hm.ba.kongo.shop.ordering.service.gen.domain.Order_;
import edu.hm.ba.kongo.shop.ordering.service.gen.services.resource.Order_ResourceService;
import edu.hm.ba.kongo.shop.ordering.service.services.resource.Order_ResourceServiceImpl;
import org.junit.Test;

import org.springframework.hateoas.Resource;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

/**
 * Created by Fabian on 25.01.2017.
 */
public class Order_ResourceServiceImplTest {

    Order_ResourceService order_resourceService = new Order_ResourceServiceImpl();

    @Test
    public void processTest(){
        Order_ order_ = new Order_();
        String cart = "testcart";
        LocalDate orderdOn = LocalDate.of(2010, 10, 10);
        order_.setCart(cart);
        order_.setOrderedOn(orderdOn);
        Resource<Order_> resource = new Resource(order_);

        Resource<Order_> process = order_resourceService.process(resource);

        assertEquals(process.getContent().getCart(), cart);
        assertEquals(process.getContent().getOrderedOn(), orderdOn);
    }
}
