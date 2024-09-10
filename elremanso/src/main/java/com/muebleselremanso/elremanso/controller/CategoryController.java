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
        List<Category> categoryList = categoryService.findAll();

        return new ResponseEntity<>(categoryList,HttpStatus.OK);
    }

    @GetMapping("categories{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){
        return new ResponseEntity<>(categoryService.findById(id),HttpStatus.OK);
    }

    @PostMapping("categories")
    public ResponseEntity<Category> save(@RequestBody @Valid CategoryDto categoryDto){
        return new ResponseEntity<>(categoryService.save(categoryDto),HttpStatus.OK);
    }



}
