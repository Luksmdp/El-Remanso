package com.muebleselremanso.elremanso.service;

import com.muebleselremanso.elremanso.model.dto.ShoppingCartDto;
import com.muebleselremanso.elremanso.model.entity.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {

    ShoppingCart save(ShoppingCartDto shoppingCartDto);
    void delete(Long id);
    List<ShoppingCart> findAll();
    ShoppingCart findById(Long id);
    ShoppingCart update(ShoppingCartDto shoppingCartDto,Long id);
}
