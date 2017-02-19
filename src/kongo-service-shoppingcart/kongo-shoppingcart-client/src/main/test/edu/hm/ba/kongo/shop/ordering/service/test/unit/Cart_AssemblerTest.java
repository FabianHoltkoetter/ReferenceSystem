package edu.hm.ba.kongo.shop.ordering.service.test.unit;

import edu.hm.ba.kongo.shop.shoppingcart.client.domain.CartItem_DTO;
import edu.hm.ba.kongo.shop.shoppingcart.client.domain.Cart_DTO;
import edu.hm.ba.kongo.shop.shoppingcart.client.hateoas.Cart_Assembler;
import edu.hm.ba.kongo.shop.shoppingcart.client.local.CartItem_;
import edu.hm.ba.kongo.shop.shoppingcart.client.local.Cart_;
import edu.hm.ba.kongo.shop.shoppingcart.client.rest.Cart_Resource;
import org.junit.Before;
import org.junit.Test;
import org.springframework.hateoas.Resource;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Fabian on 24.01.2017.
 */
public class Cart_AssemblerTest {

    private Cart_Assembler cart_assembler = new Cart_Assembler();

    private String cart_userID = "1234-5678-9112";
    private BigDecimal cart_totalPrice = new BigDecimal(12.5);
    private String cartitem_product = "Testproduct";
    private long cartitem_quantity = 2;

    private java.util.Set<CartItem_DTO> cartItem_dtos;
    private java.util.Set<CartItem_> cartItem_s = new HashSet<>(Arrays.asList(new CartItem_(cartitem_product, cartitem_quantity)));

    @Before
    public void setup(){
        CartItem_DTO cartItem_dto = new CartItem_DTO();
        cartItem_dto.setProduct(cartitem_product);
        cartItem_dto.setQuantity(cartitem_quantity);
        cartItem_dtos = new HashSet<>(Arrays.asList(cartItem_dto));
    }

    @Test
    public void toBeanTest(){

        Cart_DTO cart_dto = new Cart_DTO();
        cart_dto.setUserID(cart_userID);
        cart_dto.setTotalPrice(cart_totalPrice);
        cart_dto.setItems(cartItem_dtos);

        Resource<Cart_DTO> resource = new Resource<>(cart_dto);

        Cart_ cart_ = cart_assembler.toBean(resource);

        assertEquals(cart_.getUserID(), cart_userID);
        assertEquals(cart_.getTotalPrice(), cart_totalPrice);
        assertTrue(cart_.getItems().containsAll(cartItem_s));
    }

    @Test
    public void toResourceTest(){
        Cart_ cart_ = new Cart_(cart_userID, cart_totalPrice);
        cart_.setItems(cartItem_s);

        Cart_Resource cart_resource = cart_assembler.toResource(cart_);

        assertEquals(cart_resource.getContent().getUserID(), cart_userID);
        assertEquals(cart_resource.getContent().getTotalPrice(), cart_totalPrice);
        assertTrue(cart_resource.getContent().getItems().containsAll(cartItem_dtos));
    }

    @Test
    public void toDTOTest(){
        Cart_ cart_ = new Cart_(cart_userID, cart_totalPrice);
        cart_.setItems(cartItem_s);

        Cart_DTO cart_dto = cart_assembler.toDTO(cart_);

        assertEquals(cart_dto.getUserID(), cart_userID);
        assertEquals(cart_dto.getTotalPrice(), cart_totalPrice);
        assertTrue(cart_dto.getItems().containsAll(cartItem_dtos));
    }
}
