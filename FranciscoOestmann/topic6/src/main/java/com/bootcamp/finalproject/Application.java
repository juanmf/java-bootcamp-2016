package com.bootcamp.finalproject;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/**
 * Application Class
 *
 */
@ComponentScan
@SpringBootApplication
public class Application {
    public static void main( String[] args ) {
    	
       SpringApplication.run(Application.class, args);
    }
}
