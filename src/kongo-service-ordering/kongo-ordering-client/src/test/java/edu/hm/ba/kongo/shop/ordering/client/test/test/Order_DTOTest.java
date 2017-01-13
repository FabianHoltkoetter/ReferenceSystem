package edu.hm.ba.kongo.shop.ordering.client.test.test;


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
import org.springframework.web.client.RestTemplate;

import edu.hm.ba.kongo.shop.ordering.client.local.Order_;
import edu.hm.ba.kongo.shop.ordering.client.rest.Order_RestClient;
import edu.hm.ba.kongo.shop.ordering.client.rest.Order_RestClientImpl;
import edu.hm.ba.kongo.shop.ordering.service.MicroServiceApplication;
import edu.hm.ba.kongo.shop.ordering.service.rest.Order_Repository;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(MicroServiceApplication.class)
@WebIntegrationTest({"server.port=8080", "management.port=8080"})
public class Order_DTOTest{
	
	private static Order_RestClient restClient;
	
	@Autowired
	private Order_Repository repo;
	
	@BeforeClass
	public static void onceExecutedBeforeAll() {
		RestTemplate tmp = new RestTemplate();
		URI uri = URI.create("http://localhost:8080/");
		restClient = new Order_RestClientImpl(tmp, uri);
	}
	
	@Test
	public void testRepo(){
		Iterable<edu.hm.ba.kongo.shop.ordering.service.gen.domain.Order_> list = repo.findAll();
		Assert.notNull(list);
	}
	
    @Test
    public void createOrderTest() {
		Order_ order = new Order_();
		order.setCart("123");
		order.setOrderedOn(java.time.LocalDate.parse("10.10.2010",java.time.format.DateTimeFormatter.ofPattern("dd.MM.yyyy")));
		restClient.create(order);
		assertTrue(!restClient.findAll().contains(order));
    }
    
    @Test
    public void deleteOrderAfterCreationTest() {
    	List<Order_> before = restClient.findAll();
		Order_ order = new Order_();
		order.setCart("123");
		order.setOrderedOn(java.time.LocalDate.parse("10.10.2010",java.time.format.DateTimeFormatter.ofPattern("dd.MM.yyyy")));
		restClient.create(order);
		restClient.delete(order.getId());
		assertEquals(before, restClient.findAll());
    }


}

