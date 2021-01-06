package com.example.mongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@SpringBootApplication
@ComponentScan
public class MongodbDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongodbDemoApplication.class, args);
	}
}
