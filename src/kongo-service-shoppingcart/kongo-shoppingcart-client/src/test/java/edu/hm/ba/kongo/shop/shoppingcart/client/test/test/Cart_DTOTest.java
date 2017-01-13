package edu.hm.ba.kongo.shop.shoppingcart.client.test.test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.net.URI;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;
import java.util.List;
import java.util.Arrays;
import java.util.HashSet;
import java.math.BigDecimal;
import org.springframework.web.client.RestTemplate;

import edu.hm.ba.kongo.shop.shoppingcart.client.local.Cart_;
import edu.hm.ba.kongo.shop.shoppingcart.client.rest.Cart_RestClient;
import edu.hm.ba.kongo.shop.shoppingcart.client.rest.Cart_RestClientImpl;
import edu.hm.ba.kongo.shop.shoppingcart.service.MicroServiceApplication;
import edu.hm.ba.kongo.shop.shoppingcart.service.rest.Cart_Repository;

import edu.hm.ba.kongo.shop.shoppingcart.client.local.CartItem_;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(MicroServiceApplication.class)
@WebIntegrationTest({"server.port=8080", "management.port=8080"})
public class Cart_DTOTest{
	
	private static Cart_RestClient restClient;
	
	@Autowired
	private Cart_Repository repo;
	
	@BeforeClass
	public static void onceExecutedBeforeAll() {
		RestTemplate tmp = new RestTemplate();
		URI uri = URI.create("http://localhost:8080/");
		restClient = new Cart_RestClientImpl(tmp, uri);
	}
	
	@Test
	public void testRepo(){
		Iterable<edu.hm.ba.kongo.shop.shoppingcart.service.gen.domain.Cart_> list = repo.findAll();
		Assert.notNull(list);
	}
	
    @Test
    public void createCartTest() {
		Cart_ cart = new Cart_();
		CartItem_ cart_items = new CartItem_();
		cart_items.setProduct("123");
		cart_items.setQuantity(1L);
		cart.setItems(new HashSet(Arrays.asList(cart_items)));
		cart.setUserID("123");
		cart.setTotalPrice(new BigDecimal("15.5"));
		restClient.create(cart);
		assertTrue(!restClient.findAll().contains(cart));
    }
    
    @Test
    public void deleteCartAfterCreationTest() {
    	List<Cart_> before = restClient.findAll();
		Cart_ cart = new Cart_();
		CartItem_ cart_items = new CartItem_();
		cart_items.setProduct("123");
		cart_items.setQuantity(1L);
		cart.setItems(new HashSet(Arrays.asList(cart_items)));
		cart.setUserID("123");
		cart.setTotalPrice(new BigDecimal("15.5"));
		restClient.create(cart);
		restClient.delete(cart.getId());
		assertEquals(before, restClient.findAll());
    }


}

