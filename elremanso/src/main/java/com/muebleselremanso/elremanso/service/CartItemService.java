package com.muebleselremanso.elremanso.service;

import com.muebleselremanso.elremanso.model.dto.ApiResponse;
import com.muebleselremanso.elremanso.model.dto.CartItemDto;
import com.muebleselremanso.elremanso.model.entity.CartItem;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CartItemService {
    ResponseEntity<ApiResponse<CartItem>> save(CartItemDto cartItemDto);
    ResponseEntity<String> delete(Long id);
    ResponseEntity<ApiResponse<List<CartItem>>> findAll();
    ResponseEntity<ApiResponse<CartItem>> findById(Long id);
    ResponseEntity<ApiResponse<CartItem>> update(CartItemDto cartItemDto,Long id);
}
