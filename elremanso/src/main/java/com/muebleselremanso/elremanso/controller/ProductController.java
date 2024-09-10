package com.muebleselremanso.elremanso.controller;

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
    public ResponseEntity<List<Product>> findAll(){
        List<Product> productList = productService.findAll();

        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @GetMapping("products{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        return new ResponseEntity<>(productService.findById(id),HttpStatus.OK);
    }

    @PostMapping("products")
    public ResponseEntity<Product> save(@RequestBody @Valid ProductDto productDto){
        return new ResponseEntity<>(productService.save(productDto),HttpStatus.OK);
    }
}
