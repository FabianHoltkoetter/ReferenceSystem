package edu.hm.ba.kongo.shop.ordering.service.test.unit;

import edu.hm.ba.kongo.shop.shoppingcart.service.gen.domain.CartItem_;
import edu.hm.ba.kongo.shop.shoppingcart.service.gen.domain.Cart_;
import edu.hm.ba.kongo.shop.shoppingcart.service.gen.services.resource.Cart_ResourceService;
import edu.hm.ba.kongo.shop.shoppingcart.service.services.resource.Cart_ResourceServiceImpl;
import org.junit.Test;
import org.springframework.hateoas.Resource;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

/**
 * Created by Fabian Wilms on 25.01.2017.
 */
public class Cart_ResourceServiceImplTest {

    private Cart_ResourceService cart_resourceService = new Cart_ResourceServiceImpl();

    @Test
    public void processTest(){
        CartItem_ cartItem_ = new CartItem_();
        cartItem_.setProduct("123");
        cartItem_.setQuantity(1);

        Cart_ cart = new Cart_();
        UUID uuid = UUID.fromString("12341234-1212-1212-1212-123456123456");
        String userID = "123";
        BigDecimal totalPrice = new BigDecimal(15.5);
        Set<CartItem_> cartItemSet = new HashSet<>(Collections.singletonList(cartItem_));
        cart.setOid(uuid);
        cart.setUserID(userID);
        cart.setTotalPrice(totalPrice);
        cart.setItems(cartItemSet);

        Resource<Cart_> resource = new Resource<>(cart);

        Resource<Cart_> process = cart_resourceService.process(resource);

        assertEquals(process.getContent().getUserID(), userID);
        assertEquals(process.getContent().getItems(), cartItemSet);
        assertEquals(process.getContent().getTotalPrice(), totalPrice);
        assertEquals(process.getContent().getOid(), uuid);
    }
}
