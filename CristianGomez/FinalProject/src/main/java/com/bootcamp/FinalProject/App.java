package com.bootcamp.FinalProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Class that runs the Spring Boot application.
 * 
 * @author Cadrian
 *
 */
@ComponentScan("com.bootcamp.FinalProject")
@SpringBootApplication
public class App {
  //http://localhost:8080/swagger-ui.html (api-info)
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
