package com.muebleselremanso.elremanso.service;

import com.muebleselremanso.elremanso.model.dto.ShoppingCartDto;
import com.muebleselremanso.elremanso.model.entity.ShoppingCart;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShoppingCartServiceImpl implements ShoppingCartService{
    @Override
    public ShoppingCart save(ShoppingCartDto shoppingCartDto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<ShoppingCart> findAll() {
        return null;
    }

    @Override
    public ShoppingCart findById(Long id) {
        return null;
    }

    @Override
    public ShoppingCart update(ShoppingCartDto shoppingCartDto, Long id) {
        return null;
    }
}
