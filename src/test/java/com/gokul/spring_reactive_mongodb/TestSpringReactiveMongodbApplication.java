package com.gokul.spring_reactive_mongodb;

import org.springframework.boot.SpringApplication;

public class TestSpringReactiveMongodbApplication {

	public static void main(String[] args) {
		SpringApplication.from(SpringReactiveMongodbApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
