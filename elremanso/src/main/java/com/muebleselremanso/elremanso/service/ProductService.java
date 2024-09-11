package com.muebleselremanso.elremanso.service;

import com.muebleselremanso.elremanso.model.dto.ApiResponse;
import com.muebleselremanso.elremanso.model.dto.ProductDto;
import com.muebleselremanso.elremanso.model.entity.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {

    ResponseEntity<Product> save(ProductDto productDto);
    ResponseEntity<String> delete(Long id);
    ResponseEntity<List<Product>> findAll();
    ResponseEntity<ApiResponse<Product>> findById(Long id);
    ResponseEntity<Product> update(ProductDto productDto,Long id);
}
