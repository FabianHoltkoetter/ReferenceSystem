package edu.hm.ba.kongo.infrastructure.edge;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = EdgeServerApplication.class)
@WebAppConfiguration
public class EdgeServerApplicationTest {

	@Test
	public void contextLoads() {
	}

}
