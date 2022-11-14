package com.example.kbe.htw.demo.food;

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
public class FoodController {

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
    FoodRepository foodRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Food> getFoodById(@PathVariable(value = "id") Long id) {
        Optional<Food> product = this.foodRepository.findById(id);
        return product.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(product.get());
    }

    @GetMapping("")
    public ResponseEntity<List<Food>> getFoods() {
        return ResponseEntity.ok(this.foodRepository.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Food> deleteFoodById(@PathVariable(value = "id") Long id) {
        Optional<Food> product = this.foodRepository.findById(id);
        this.foodRepository.deleteById(id);
        return product.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(product.get());

    }

    @PostMapping("")
    public ResponseEntity<Food> createFood(@RequestBody @Valid Food food) {
        Food saved = this.foodRepository.save(food);

        return ResponseEntity.ok(saved);
    }

}
