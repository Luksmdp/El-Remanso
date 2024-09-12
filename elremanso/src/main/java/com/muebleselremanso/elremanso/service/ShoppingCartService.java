package com.muebleselremanso.elremanso.service;

import com.muebleselremanso.elremanso.model.dto.ApiResponse;
import com.muebleselremanso.elremanso.model.dto.ShoppingCartDto;
import com.muebleselremanso.elremanso.model.entity.ShoppingCart;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ShoppingCartService {

    ResponseEntity<ApiResponse<ShoppingCart>> save();
    ResponseEntity<String> delete(Long id);
    ResponseEntity<ApiResponse<List<ShoppingCart>>> findAll();
    ResponseEntity<ApiResponse<ShoppingCart>> findById(Long id);
    ResponseEntity<ApiResponse<ShoppingCart>> update(ShoppingCartDto shoppingCartDto,Long id);
}
