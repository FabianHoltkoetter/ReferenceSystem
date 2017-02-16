package unit;

import edu.hm.ba.kongo.shop.ordering.client.domain.OrderingItem_DTO;
import edu.hm.ba.kongo.shop.ordering.client.hateoas.OrderingItem_Assembler;
import edu.hm.ba.kongo.shop.ordering.client.local.OrderingItem_;
import edu.hm.ba.kongo.shop.ordering.client.rest.OrderingItem_Resource;
import org.junit.Test;
import org.springframework.hateoas.Resource;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

/**
 * Created by Fabian on 24.01.2017.
 */
public class Order_AssemblerTest {

    private OrderingItem_Assembler order_assembler = new OrderingItem_Assembler();

    private String order_cartName = "Testcart";
    private LocalDate order_orderedOn = LocalDate.of(2010,12,12);

    @Test
    public void toBeanTest(){
        OrderingItem_DTO order_dto = new OrderingItem_DTO();
        order_dto.setCart(order_cartName);
        order_dto.setOrderedOn(order_orderedOn);

        Resource<OrderingItem_DTO> resource = new Resource<>(order_dto);

        OrderingItem_ order_ = order_assembler.toBean(resource);

        assertEquals(order_.getCart(), order_cartName);
        assertEquals(order_.getOrderedOn(), order_orderedOn);
    }

    @Test
    public void toResourceTest(){
        OrderingItem_ order_ = new OrderingItem_(order_cartName, order_orderedOn);

        OrderingItem_Resource order_resource = order_assembler.toResource(order_);

        assertEquals(order_resource.getContent().getCart(), order_cartName);
        assertEquals(order_resource.getContent().getOrderedOn(), order_orderedOn);
    }

    @Test
    public void toDTOTest(){
        OrderingItem_ order_ = new OrderingItem_(order_cartName, order_orderedOn);

        OrderingItem_DTO order_dto = order_assembler.toDTO(order_);

        assertEquals(order_dto.getCart(), order_cartName);
        assertEquals(order_dto.getOrderedOn(), order_orderedOn);
    }
}
