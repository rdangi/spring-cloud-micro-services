package com.rdangi.springbootadmin;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations = {"classpath:disable-eureka-cloud-config.properties"})
class SpringBootAdminApplicationTests {

	@Test
	void contextLoads() {
	}

}
