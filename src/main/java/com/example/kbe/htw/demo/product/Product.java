package com.example.kbe.htw.demo.product;

import com.opencsv.bean.CsvBindByName;
import lombok.*;

import java.util.Currency;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @CsvBindByName
    private int id;

    @CsvBindByName
    private String name;

    @CsvBindByName
    private String description;

    @CsvBindByName
    private Float price;

    @CsvBindByName
    private String currency;

    @CsvBindByName
    private String category;

}
