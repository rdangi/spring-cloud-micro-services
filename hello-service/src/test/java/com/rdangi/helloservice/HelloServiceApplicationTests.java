package com.rdangi.helloservice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(properties = {"role=tester"})
public class HelloServiceApplicationTests {

	@Test
	public void contextLoads() {

	}

}
