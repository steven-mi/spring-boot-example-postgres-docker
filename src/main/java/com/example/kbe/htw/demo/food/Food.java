package com.example.kbe.htw.demo.food;

import com.example.kbe.htw.demo.restaurant.Restaurant;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    private String description = "";

    @Positive(message = "Price needs to be positive")
    private Float price;

    @NotBlank(message = "Currency is mandatory")
    private String currency;

    @NotBlank(message = "Category is mandatory")
    private String category;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable=false)
    @JsonIgnore
    private Restaurant restaurant;

}
