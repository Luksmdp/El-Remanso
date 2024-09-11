package com.muebleselremanso.elremanso.service;

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
    public ResponseEntity<Product> save(ProductDto productDto) {

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
                    .body(productRepository.save(product));
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null);
        }


    }

    @Override
    public ResponseEntity<String> delete(Long id) {

        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Product with id " + id + " not found");
        }
        else {
            productRepository.delete(productOptional.get());
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Product with id " + id + " deleted successfully");
        }
    }

    @Override
    public ResponseEntity<List<Product>> findAll() {
        return null;
    }

    @Override
    public ResponseEntity<Product> findById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Product> update(ProductDto productDto, Long id) {
        return null;
    }
}
