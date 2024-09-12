package com.muebleselremanso.elremanso.controller;

import com.muebleselremanso.elremanso.model.dto.ApiResponse;
import com.muebleselremanso.elremanso.model.dto.CartItemDto;
import com.muebleselremanso.elremanso.model.dto.ShoppingCartDto;
import com.muebleselremanso.elremanso.model.entity.CartItem;
import com.muebleselremanso.elremanso.model.entity.ShoppingCart;
import com.muebleselremanso.elremanso.service.ShoppingCartService;
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
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    @GetMapping("shoppingCarts")
    public ResponseEntity<ApiResponse<List<ShoppingCart>>> findAll(){

        return shoppingCartService.findAll();
    }

    @GetMapping("shoppingCarts/{id}")
    public ResponseEntity<ApiResponse<ShoppingCart>> findById(@PathVariable Long id){
        return shoppingCartService.findById(id);
    }

    @PostMapping("shoppingCarts")
    public ResponseEntity<ApiResponse<ShoppingCart>> save(){
        return shoppingCartService.save();
    }

    @DeleteMapping("shoppingCarts/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        return shoppingCartService.delete(id);
    }
}
