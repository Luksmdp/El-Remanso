package com.muebleselremanso.elremanso.service;

import com.muebleselremanso.elremanso.model.dto.CategoryDto;
import com.muebleselremanso.elremanso.model.entity.Category;
import com.muebleselremanso.elremanso.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;
    @Override
    public ResponseEntity<Category> save(CategoryDto categoryDto) {

        Category category = Category.builder()
                .name(categoryDto.getName())
                .description(categoryDto.getDescription())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED)
                        .body(categoryRepository.save(category));
    }

    @Override
    public ResponseEntity<String> delete(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<Category>> findAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(categoryRepository.findAll());
    }

    @Override
    public ResponseEntity<Category> findById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Category> update(CategoryDto categoryDto, Long id) {
        return null;
    }
}
