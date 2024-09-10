package com.muebleselremanso.elremanso.service;

import com.muebleselremanso.elremanso.model.dto.CartItemDto;
import com.muebleselremanso.elremanso.model.entity.CartItem;

import java.util.List;

public interface CartItemService {
    CartItem save(CartItemDto cartItemDto);
    void delete(Long id);
    List<CartItem> findAll();
    CartItem findById(Long id);
    CartItem update(CartItemDto cartItemDto,Long id);
}
