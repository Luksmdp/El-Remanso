package com.muebleselremanso.elremanso.controller;

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
    public ResponseEntity<List<ShoppingCart>> findAll(){
        List<ShoppingCart> shoppingCartList = shoppingCartService.findAll();

        return new ResponseEntity<>(shoppingCartList, HttpStatus.OK);
    }

    @GetMapping("shoppingCarts{id}")
    public ResponseEntity<ShoppingCart> findById(@PathVariable Long id){
        return new ResponseEntity<>(shoppingCartService.findById(id),HttpStatus.OK);
    }

    @PostMapping("shoppingCarts")
    public ResponseEntity<ShoppingCart> save(@RequestBody @Valid ShoppingCartDto shoppingCartDto){
        return new ResponseEntity<>(shoppingCartService.save(shoppingCartDto),HttpStatus.OK);
    }
}
