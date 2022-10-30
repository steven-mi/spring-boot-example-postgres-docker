package com.example.kbe.htw.demo.product;

import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Repository;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.List;

@Repository
public class ProductRepository {

    private List<Product> foodList;

    public ProductRepository() throws FileNotFoundException {
        URL url = getClass().getClassLoader().getResource("food.csv");
        String csv_path = url.getPath().toString();
        this.foodList = new CsvToBeanBuilder(new FileReader(csv_path))
                .withType(Product.class)
                .build()
                .parse();

    }

    public Product findById(Integer id) {
        return this.foodList.stream().filter(product -> product.getId() == id).findAny().orElse(null);
    }

    public List<Product> findAll() {
        return this.foodList;
    }
}
