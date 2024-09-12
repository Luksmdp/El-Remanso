package com.muebleselremanso.elremanso.controller;

import com.muebleselremanso.elremanso.model.dto.ApiResponse;
import com.muebleselremanso.elremanso.model.dto.CartItemDto;
import com.muebleselremanso.elremanso.model.dto.ProductDto;
import com.muebleselremanso.elremanso.model.entity.CartItem;
import com.muebleselremanso.elremanso.model.entity.Product;
import com.muebleselremanso.elremanso.model.entity.ShoppingCart;
import com.muebleselremanso.elremanso.service.CartItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Validated
public class CartItemController {

    private final CartItemService cartItemService;

    @GetMapping("cartItems")
    public ResponseEntity<ApiResponse<List<CartItem>>> findAll(){

        return cartItemService.findAll();
    }

    @GetMapping("cartItems/{id}")
    public ResponseEntity<ApiResponse<CartItem>> findById(@PathVariable Long id){
        return cartItemService.findById(id);
    }

    @PostMapping("cartItems")
    public ResponseEntity<ApiResponse<CartItem>> save(@RequestBody @Valid CartItemDto cartItemDto){
        return cartItemService.save(cartItemDto);
    }

    @DeleteMapping("cartItems/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        return cartItemService.delete(id);
    }
}
