package com.springboot.data.rest.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.springboot.data.rest.demo"})
public class SpringDataRestCruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataRestCruddemoApplication.class, args);
	}

}
