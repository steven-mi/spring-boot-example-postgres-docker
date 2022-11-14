package com.example.kbe.htw.demo;

import com.example.kbe.htw.demo.food.Food;
import com.example.kbe.htw.demo.food.FoodRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(FoodRepository repository) {
        return (args) -> {
            // save a few customers
            repository.save(new Food(1L, "Chicken Boneless (ohne Knochen)", "1) Plain no sauce 2) Sweet chili (Peanut topping) 3) Soy garlic 4) Super spicy 5) Soy wasabi", 12.50F, "EUR", "food"));
            repository.save(new Food(2L, "Chicken Cuts (mit Knochen)", "1) Plain no sauce 2) Sweet chili (Peanut topping) 3) Soy garlic 4) Super spicy 5) Soy wasabi", 12.00F, "EUR", "food"));
            repository.save(new Food(3L, "Beef Dumpling", "BBQ Beef Fried Dumpling (4 PCS)", 6.50F, "EUR", "side"));
        };

    }


}

