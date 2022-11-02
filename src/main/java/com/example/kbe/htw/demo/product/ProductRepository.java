package com.example.kbe.htw.demo.product;

import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Repository;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

@Repository
public class ProductRepository {

    private List<Product> foodList;

    public ProductRepository() {
        this.initialiseFoodList();
    }

    private void initialiseFoodList() {
        try {
            URL url = getClass().getClassLoader().getResource("food.csv");
            String csv_path = url.getPath().toString();
            this.foodList = new CsvToBeanBuilder(new FileReader(csv_path))
                    .withType(Product.class)
                    .build()
                    .parse();
        } catch (FileNotFoundException e) {
            this.foodList = new LinkedList<Product>();
        }

    }

    public Product findById(Integer id) {
        return this.foodList.stream().filter(product -> product.getId() == id).findAny().orElse(null);
    }

    public List<Product> findAll() {
        return this.foodList;
    }
}
