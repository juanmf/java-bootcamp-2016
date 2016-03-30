package com.carrito;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket newsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("api-info").apiInfo(apiInfo()).select()
				.apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
				.paths(regex("/.*")).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Shopping Cart api REST")
				.description("simple Shopping Cart for bootcamp 2016 using SpringBoot and MySQL")
				.contact("gonza181092@gmail.com").license("Apache License Version 2.0").version("1.0").build();
	}

}
