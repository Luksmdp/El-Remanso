package com.muebleselremanso.elremanso.service;

import com.muebleselremanso.elremanso.model.dto.CartItemDto;
import com.muebleselremanso.elremanso.model.entity.CartItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartItemServiceImpl implements CartItemService{
    @Override
    public CartItem save(CartItemDto cartItemDto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<CartItem> findAll() {
        return null;
    }

    @Override
    public CartItem findById(Long id) {
        return null;
    }

    @Override
    public CartItem update(CartItemDto cartItemDto, Long id) {
        return null;
    }
}
