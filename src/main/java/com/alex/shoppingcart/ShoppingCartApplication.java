package com.alex.shoppingcart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.alex.shoppingcart.data")
@OpenAPIDefinition // http://localhost:8080/swagger-ui.html
// @ComponentScan(basePackages = "com.alex.shoppingcart.*")
public class ShoppingCartApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingCartApplication.class, args);
    }

}
