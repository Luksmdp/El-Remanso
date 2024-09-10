package com.muebleselremanso.elremanso.service;

import com.muebleselremanso.elremanso.model.dto.ProductDto;
import com.muebleselremanso.elremanso.model.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    @Override
    public Product save(ProductDto productDto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public Product findById(Long id) {
        return null;
    }

    @Override
    public Product update(ProductDto productDto, Long id) {
        return null;
    }
}
