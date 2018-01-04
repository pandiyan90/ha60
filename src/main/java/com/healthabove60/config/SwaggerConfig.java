package com.healthabove60.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(Predicates.not(PathSelectors.regex("/*")))
				.build()
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		String description = "HealthAbove60 Web Application";
		return new ApiInfoBuilder()
				.title("HealthAbove60")
				.description(description)
				.termsOfServiceUrl("")
				.license("HealthAbove60")
				.licenseUrl("")
				.version("1.0")
				.build();
	}

}