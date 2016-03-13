package com.bootcamp.Topic6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Class that runs the Spring Boot application.
 * 
 * @author Cadrian
 *
 */

@SpringBootApplication
public class App {
  //http://localhost:8080/swagger-ui.html (api-docs)
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
