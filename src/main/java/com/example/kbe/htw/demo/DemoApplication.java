package com.example.kbe.htw.demo;

import com.example.kbe.htw.demo.product.Product;
import com.example.kbe.htw.demo.product.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(ProductRepository repository) {
        return (args) -> {
            // save a few customers
            repository.save(new Product(1L, "Chicken Boneless (ohne Knochen)", "1) Plain no sauce 2) Sweet chili (Peanut topping) 3) Soy garlic 4) Super spicy 5) Soy wasabi", 12.50F, "EUR", "food"));
            repository.save(new Product(2L, "Chicken Cuts (mit Knochen)", "1) Plain no sauce 2) Sweet chili (Peanut topping) 3) Soy garlic 4) Super spicy 5) Soy wasabi", 12.00F, "EUR", "food"));
            repository.save(new Product(3L, "Beef Dumpling", "BBQ Beef Fried Dumpling (4 PCS)", 6.50F, "EUR", "side"));
        };

    }


}

