package com.muebleselremanso.elremanso.service;

import com.muebleselremanso.elremanso.model.dto.ShoppingCartDto;
import com.muebleselremanso.elremanso.model.entity.ShoppingCart;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ShoppingCartService {

    ResponseEntity<ShoppingCart> save(ShoppingCartDto shoppingCartDto);
    ResponseEntity<String> delete(Long id);
    ResponseEntity<List<ShoppingCart>> findAll();
    ResponseEntity<ShoppingCart> findById(Long id);
    ResponseEntity<ShoppingCart> update(ShoppingCartDto shoppingCartDto,Long id);
}
