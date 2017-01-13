package edu.hm.ba.kongo.shop.warehouse.client.test.test;


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
import java.math.BigDecimal;
import org.springframework.web.client.RestTemplate;

import edu.hm.ba.kongo.shop.warehouse.client.local.Product_;
import edu.hm.ba.kongo.shop.warehouse.client.rest.Product_RestClient;
import edu.hm.ba.kongo.shop.warehouse.client.rest.Product_RestClientImpl;
import edu.hm.ba.kongo.shop.warehouse.service.MicroServiceApplication;
import edu.hm.ba.kongo.shop.warehouse.service.rest.Product_Repository;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(MicroServiceApplication.class)
@WebIntegrationTest({"server.port=8080", "management.port=8080"})
public class Product_DTOTest{
	
	private static Product_RestClient restClient;
	
	@Autowired
	private Product_Repository repo;
	
	@BeforeClass
	public static void onceExecutedBeforeAll() {
		RestTemplate tmp = new RestTemplate();
		URI uri = URI.create("http://localhost:8080/");
		restClient = new Product_RestClientImpl(tmp, uri);
	}
	
	@Test
	public void testRepo(){
		Iterable<edu.hm.ba.kongo.shop.warehouse.service.gen.domain.Product_> list = repo.findAll();
		Assert.notNull(list);
	}
	
    @Test
    public void createProductTest() {
		Product_ product = new Product_();
		product.setName("Bottle");
		product.setPrice(new BigDecimal("10.5"));
		product.setQuantity(5L);
		restClient.create(product);
		assertTrue(!restClient.findAll().contains(product));
    }
    
    @Test
    public void deleteProductAfterCreationTest() {
    	List<Product_> before = restClient.findAll();
		Product_ product = new Product_();
		product.setName("Bottle");
		product.setPrice(new BigDecimal("10.5"));
		product.setQuantity(5L);
		restClient.create(product);
		restClient.delete(product.getId());
		assertEquals(before, restClient.findAll());
    }


}

