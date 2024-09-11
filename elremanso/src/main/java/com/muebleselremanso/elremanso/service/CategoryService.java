package com.muebleselremanso.elremanso.service;

import com.muebleselremanso.elremanso.model.dto.CategoryDto;
import com.muebleselremanso.elremanso.model.entity.Category;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoryService {

    ResponseEntity<Category> save(CategoryDto categoryDto);
    ResponseEntity<String> delete(Long id);
    ResponseEntity<List<Category>> findAll();
    ResponseEntity<Category> findById(Long id);
    ResponseEntity<Category> update(CategoryDto categoryDto,Long id);
}
