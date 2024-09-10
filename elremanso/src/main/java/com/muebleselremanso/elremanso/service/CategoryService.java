package com.muebleselremanso.elremanso.service;

import com.muebleselremanso.elremanso.model.dto.CategoryDto;
import com.muebleselremanso.elremanso.model.entity.Category;

import java.util.List;

public interface CategoryService {

    Category save(CategoryDto categoryDto);
    void delete(Long id);
    List<Category> findAll();
    Category findById(Long id);
    Category update(CategoryDto categoryDto,Long id);
}
