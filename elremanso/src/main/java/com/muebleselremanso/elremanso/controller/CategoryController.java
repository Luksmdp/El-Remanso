package com.muebleselremanso.elremanso.controller;

import com.muebleselremanso.elremanso.model.dto.CategoryDto;
import com.muebleselremanso.elremanso.model.entity.Category;
import com.muebleselremanso.elremanso.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("categories")
    public ResponseEntity<List<Category>> findAll(){
        return categoryService.findAll();

    }

    @GetMapping("categories{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){
        return categoryService.findById(id);
    }

    @PostMapping("categories")
    public ResponseEntity<Category> save(@RequestBody @Valid CategoryDto categoryDto){
        return categoryService.save(categoryDto);
    }



}
