package com.muebleselremanso.elremanso.service;

import com.muebleselremanso.elremanso.model.dto.CartItemDto;
import com.muebleselremanso.elremanso.model.entity.CartItem;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CartItemService {
    ResponseEntity<CartItem> save(CartItemDto cartItemDto);
    ResponseEntity<String> delete(Long id);
    ResponseEntity<List<CartItem>> findAll();
    ResponseEntity<CartItem> findById(Long id);
    ResponseEntity<CartItem> update(CartItemDto cartItemDto,Long id);
}
