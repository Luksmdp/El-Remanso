package com.muebleselremanso.elremanso.service;

import com.muebleselremanso.elremanso.model.dto.CategoryDto;
import com.muebleselremanso.elremanso.model.entity.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{
    @Override
    public Category save(CategoryDto categoryDto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Category> findAll() {
        return null;
    }

    @Override
    public Category findById(Long id) {
        return null;
    }

    @Override
    public Category update(CategoryDto categoryDto, Long id) {
        return null;
    }
}
