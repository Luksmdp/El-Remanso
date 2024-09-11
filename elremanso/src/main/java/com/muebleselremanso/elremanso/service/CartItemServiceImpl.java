package com.muebleselremanso.elremanso.service;

import com.muebleselremanso.elremanso.model.dto.CartItemDto;
import com.muebleselremanso.elremanso.model.entity.CartItem;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartItemServiceImpl implements CartItemService{
    @Override
    public ResponseEntity<CartItem> save(CartItemDto cartItemDto) {
        return null;
    }

    @Override
    public ResponseEntity<String> delete(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<CartItem>> findAll() {
        return null;
    }

    @Override
    public ResponseEntity<CartItem> findById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<CartItem> update(CartItemDto cartItemDto, Long id) {
        return null;
    }
}
