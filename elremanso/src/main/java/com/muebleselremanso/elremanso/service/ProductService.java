package com.muebleselremanso.elremanso.service;

import com.muebleselremanso.elremanso.model.dto.ProductDto;
import com.muebleselremanso.elremanso.model.entity.Product;

import java.util.List;

public interface ProductService {

    Product save(ProductDto productDto);
    void delete(Long id);
    List<Product> findAll();
    Product findById(Long id);
    Product update(ProductDto productDto,Long id);
}
