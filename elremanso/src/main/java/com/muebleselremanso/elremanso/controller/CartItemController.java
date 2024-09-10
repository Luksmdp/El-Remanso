package com.muebleselremanso.elremanso.controller;

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
    public ResponseEntity<List<CartItem>> findAll(){
        List<CartItem> cartItemList = cartItemService.findAll();

        return new ResponseEntity<>(cartItemList, HttpStatus.OK);
    }

    @GetMapping("cartItems{id}")
    public ResponseEntity<CartItem> findById(@PathVariable Long id){
        return new ResponseEntity<>(cartItemService.findById(id),HttpStatus.OK);
    }

    @PostMapping("cartItems")
    public ResponseEntity<CartItem> save(@RequestBody @Valid CartItemDto cartItemDto){
        return new ResponseEntity<>(cartItemService.save(cartItemDto),HttpStatus.OK);
    }
}
