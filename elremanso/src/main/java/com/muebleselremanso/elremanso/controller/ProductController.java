package com.muebleselremanso.elremanso.controller;

import com.muebleselremanso.elremanso.model.dto.ApiResponse;
import com.muebleselremanso.elremanso.model.dto.CategoryDto;
import com.muebleselremanso.elremanso.model.dto.ProductDto;
import com.muebleselremanso.elremanso.model.entity.Product;
import com.muebleselremanso.elremanso.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Validated
public class ProductController {

    private final ProductService productService;

    @GetMapping("products")
    public ResponseEntity<List<Product>> findAllProducts(){

        return productService.findAll();
    }

    @GetMapping("products{id}")
    public ResponseEntity<ApiResponse<Product>> findProductById(@PathVariable Long id){
        return productService.findById(id);
    }

    @PostMapping("products")
    public ResponseEntity<Product> saveProduct(@RequestBody @Valid ProductDto productDto){
        return productService.save(productDto);
    }

    @DeleteMapping("products/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id){
        return productService.delete(id);
    }
}
