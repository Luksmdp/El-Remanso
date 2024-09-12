package com.muebleselremanso.elremanso.service;

import com.muebleselremanso.elremanso.model.dto.ApiResponse;
import com.muebleselremanso.elremanso.model.dto.ProductDto;
import com.muebleselremanso.elremanso.model.entity.Category;
import com.muebleselremanso.elremanso.model.entity.Product;
import com.muebleselremanso.elremanso.repository.CategoryRepository;
import com.muebleselremanso.elremanso.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public ResponseEntity<ApiResponse<Product>> save(ProductDto productDto) {

        Optional<Category> categoryOptional = categoryRepository.findById(productDto.getCategoryId());

        if (categoryOptional.isPresent()) {

            Product product = Product.builder()
                    .name(productDto.getName())
                    .description(productDto.getDescription())
                    .price(productDto.getPrice())
                    .promotionalPrice(productDto.getPromotionalPrice())
                    .category(categoryOptional.get())
                    .build();

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ApiResponse<>("Producto guardado correctamente",productRepository.save(product)));
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse<>("Categoria no encontrada",null));
        }


    }

    @Override
    public ResponseEntity<String> delete(Long id) {

        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Producto con id " + id + " no encontrado");
        }
        else {
            productRepository.delete(productOptional.get());
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Producto con id " + id + " eliminado correctamente");
        }
    }

    @Override
    public ResponseEntity<ApiResponse<List<Product>>> findAll() {
        if (productRepository.findAll().isEmpty())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse<>("No se encontro ningun producto",null));
        }
        else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse<>("Productos encontrados",productRepository.findAll()));
        }
    }

    @Override
    public ResponseEntity<ApiResponse<Product>> findById(Long id) {
        return productRepository.findById(id)
                .map(product -> ResponseEntity.ok().body(new  ApiResponse<>("Producto encontrado",product)))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ApiResponse<>("El producto con id " + id + " no fue encontrado", null)));
    }

    @Override
    public ResponseEntity<ApiResponse<Product>> update(ProductDto productDto, Long id) {
        return null;
    }
}
