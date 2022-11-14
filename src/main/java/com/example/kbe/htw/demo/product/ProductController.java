package com.example.kbe.htw.demo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable(value = "id") Long id) {
        Optional<Product> product = this.productRepository.findById(id);
        return product.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(product.get());
    }

    @GetMapping("")
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok(this.productRepository.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProductById(@PathVariable(value = "id") Long id) {
        Optional<Product> product = this.productRepository.findById(id);
        this.productRepository.deleteById(id);
        return product.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(product.get());

    }

    @PostMapping("")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product saved = this.productRepository.save(product);

        return  ResponseEntity.ok(saved);
    }

}
