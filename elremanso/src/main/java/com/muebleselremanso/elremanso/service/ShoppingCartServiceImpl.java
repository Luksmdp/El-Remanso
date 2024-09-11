package com.muebleselremanso.elremanso.service;

import com.muebleselremanso.elremanso.model.dto.ShoppingCartDto;
import com.muebleselremanso.elremanso.model.entity.ShoppingCart;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShoppingCartServiceImpl implements ShoppingCartService{
    @Override
    public ResponseEntity<ShoppingCart> save(ShoppingCartDto shoppingCartDto) {
        return null;
    }

    @Override
    public ResponseEntity<String> delete(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<ShoppingCart>> findAll() {
        return null;
    }

    @Override
    public ResponseEntity<ShoppingCart> findById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<ShoppingCart> update(ShoppingCartDto shoppingCartDto, Long id) {
        return null;
    }
}
