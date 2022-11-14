package com.example.kbe.htw.demo;

import com.example.kbe.htw.demo.food.Food;
import com.example.kbe.htw.demo.food.FoodRepository;
import com.example.kbe.htw.demo.restaurant.Restaurant;
import com.example.kbe.htw.demo.restaurant.RestaurantRepository;
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
    public CommandLineRunner demo(FoodRepository foodRepository, RestaurantRepository restaurantRepository) {
        return (args) -> {
            Restaurant restaurant = restaurantRepository.save(Restaurant.builder().name("Kokio").build());
            foodRepository.save(Food
                    .builder()
                    .name("Chicken Boneless (ohne Knochen)")
                    .description("1) Plain no sauce 2) Sweet chili (Peanut topping) 3) Soy garlic 4) Super spicy 5) Soy wasabi")
                    .currency("EUR")
                    .category("food")
                    .price(12.50F)
                    .restaurant(restaurant)
                    .build());
            foodRepository.save(Food
                    .builder()
                    .name("Chicken Cuts (mit Knochen)")
                    .description("1) Plain no sauce 2) Sweet chili (Peanut topping) 3) Soy garlic 4) Super spicy 5) Soy wasabi")
                    .currency("EUR")
                    .category("food")
                    .price(12.00F)
                    .restaurant(restaurant)
                    .build());
            foodRepository.save(Food
                    .builder()
                    .name("Beef Dumpling")
                    .description("BBQ Beef Fried Dumpling (4 PCS)")
                    .currency("EUR")
                    .category("side")
                    .price(6.50F)
                    .restaurant(restaurant)
                    .build());
        };
    }


}

