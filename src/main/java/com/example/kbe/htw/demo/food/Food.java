package com.example.kbe.htw.demo.food;

import lombok.*;

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

}
