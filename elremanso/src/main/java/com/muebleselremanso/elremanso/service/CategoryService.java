package com.muebleselremanso.elremanso.service;

import com.muebleselremanso.elremanso.model.dto.ApiResponse;
import com.muebleselremanso.elremanso.model.dto.CategoryDto;
import com.muebleselremanso.elremanso.model.entity.Category;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoryService {

    ResponseEntity<ApiResponse<Category>> save(CategoryDto categoryDto);
    ResponseEntity<String> delete(Long id);
    ResponseEntity<ApiResponse<List<Category>>> findAll();
    ResponseEntity<ApiResponse<Category>> findById(Long id);
    ResponseEntity<ApiResponse<Category>> update(CategoryDto categoryDto,Long id);
}
