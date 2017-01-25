package unit;

import edu.hm.ba.kongo.shop.ordering.client.domain.Order_DTO;
import edu.hm.ba.kongo.shop.ordering.client.hateoas.Order_Assembler;
import edu.hm.ba.kongo.shop.ordering.client.local.Order_;
import edu.hm.ba.kongo.shop.ordering.client.rest.Order_Resource;
import org.junit.Test;
import org.springframework.hateoas.Resource;

import javax.persistence.criteria.Order;
import java.time.LocalDate;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

/**
 * Created by Fabian on 24.01.2017.
 */
public class Order_AssemblerTest {

    private Order_Assembler order_assembler = new Order_Assembler();

    private String order_cartName = "Testcart";
    private LocalDate order_orderedOn = LocalDate.of(2010,12,12);

    @Test
    public void toBeanTest(){
        Order_DTO order_dto = new Order_DTO();
        order_dto.setCart(order_cartName);
        order_dto.setOrderedOn(order_orderedOn);

        Resource<Order_DTO> resource = new Resource<>(order_dto);

        Order_ order_ = order_assembler.toBean(resource);

        assertEquals(order_.getCart(), order_cartName);
        assertEquals(order_.getOrderedOn(), order_orderedOn);
    }

    @Test
    public void toResourceTest(){
        Order_ order_ = new Order_(order_cartName, order_orderedOn);

        Order_Resource order_resource = order_assembler.toResource(order_);

        assertEquals(order_resource.getContent().getCart(), order_cartName);
        assertEquals(order_resource.getContent().getOrderedOn(), order_orderedOn);
    }

    @Test
    public void toDTOTest(){
        Order_ order_ = new Order_(order_cartName, order_orderedOn);

        Order_DTO order_dto = order_assembler.toDTO(order_);

        assertEquals(order_dto.getCart(), order_cartName);
        assertEquals(order_dto.getOrderedOn(), order_orderedOn);
    }
}
