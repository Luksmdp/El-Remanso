package com.muebleselremanso.elremanso.service;

import com.muebleselremanso.elremanso.model.dto.ApiResponse;
import com.muebleselremanso.elremanso.model.dto.CategoryDto;
import com.muebleselremanso.elremanso.model.entity.Category;
import com.muebleselremanso.elremanso.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;
    @Override
    public ResponseEntity<ApiResponse<Category>> save(CategoryDto categoryDto) {

        Category category = Category.builder()
                .name(categoryDto.getName())
                .description(categoryDto.getDescription())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED)
                        .body(new ApiResponse<>("Categoria creada Correctamente"
                                ,categoryRepository.save(category)));
    }

    @Override
    public ResponseEntity<String> delete(Long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);

        if (categoryOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Categoria con id " + id + " no encontrada");
        }
        else{
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Categoria con id " + id + " borrada correctamente");
        }
    }

    @Override
    public ResponseEntity<ApiResponse<List<Category>>> findAll() {
        List<Category> categoryList = categoryRepository.findAll();
        if (categoryList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse<>("No se encontron ninguna categoria",null));
        }
        else{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse<>("Categorias encontradas",categoryList));
        }
    }

    @Override
    public ResponseEntity<ApiResponse<Category>> findById(Long id) {
        return categoryRepository.findById(id)
                .map(category -> ResponseEntity.status(HttpStatus.OK)
                        .body(new ApiResponse<>("Categoria encontrada",category)))
                .orElseGet(()-> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ApiResponse<>("Categoria no encontrada",null)));
    }

    @Override
    public ResponseEntity<ApiResponse<Category>> update(CategoryDto categoryDto, Long id) {
        return null;
    }
}
