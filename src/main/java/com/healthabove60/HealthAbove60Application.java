package com.healthabove60;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class HealthAbove60Application {

	public static void main(String[] args) {
		SpringApplication.run(HealthAbove60Application.class, args);
	}
}
