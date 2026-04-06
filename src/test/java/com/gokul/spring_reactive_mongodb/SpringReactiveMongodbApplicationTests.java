package com.gokul.spring_reactive_mongodb;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class SpringReactiveMongodbApplicationTests {

	@Test
	void contextLoads() {
	}

}
