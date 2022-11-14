package com.example.kbe.htw.demo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Validated
@RestController
@RequestMapping("/products")
public class ProductController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

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
    public ResponseEntity<Product> createProduct(@RequestBody @Valid Product product) {
        Product saved = this.productRepository.save(product);

        return ResponseEntity.ok(saved);
    }

}
