package com.muebleselremanso.elremanso.service;

import com.muebleselremanso.elremanso.model.dto.ApiResponse;
import com.muebleselremanso.elremanso.model.dto.ProductDto;
import com.muebleselremanso.elremanso.model.entity.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {

    ResponseEntity<ApiResponse<Product>> save(ProductDto productDto);
    ResponseEntity<String> delete(Long id);
    ResponseEntity<ApiResponse<List<Product>>> findAll();
    ResponseEntity<ApiResponse<Product>> findById(Long id);
    ResponseEntity<ApiResponse<Product>> update(ProductDto productDto,Long id);
    ResponseEntity<ApiResponse<List<Product>>> findByCategoryAndPriceBetween(Long categoryId, Double priceMin, Double priceMax);
}
