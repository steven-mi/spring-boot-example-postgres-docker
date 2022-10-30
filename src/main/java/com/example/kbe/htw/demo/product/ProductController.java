package com.example.kbe.htw.demo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

     @Autowired
     ProductRepository productRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable(value = "id") Integer id) {
        Product product = this.productRepository.findById(id);
        return product == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(product);
    }

    @GetMapping("/")
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok(this.productRepository.findAll());
    }


}
