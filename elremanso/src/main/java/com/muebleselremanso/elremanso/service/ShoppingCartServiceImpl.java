package com.muebleselremanso.elremanso.service;

import com.muebleselremanso.elremanso.model.dto.ApiResponse;
import com.muebleselremanso.elremanso.model.dto.ShoppingCartDto;
import com.muebleselremanso.elremanso.model.entity.ShoppingCart;
import com.muebleselremanso.elremanso.repository.ShoppingCartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShoppingCartServiceImpl implements ShoppingCartService{

    private final ShoppingCartRepository shoppingCartRepository;
    @Override
    public ResponseEntity<ApiResponse<ShoppingCart>> save() {
        ShoppingCart shoppingCart = new ShoppingCart();
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>("Carrito creado correctamente"
                        ,shoppingCartRepository.save(shoppingCart)));
    }

    @Override
    public ResponseEntity<String> delete(Long id) {
        Optional<ShoppingCart> shoppingCartOptional = shoppingCartRepository.findById(id);
        if (shoppingCartOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Carrito con Id " + id + " no encontrado");
        }
        else {
            shoppingCartRepository.delete(shoppingCartOptional.get());
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Carrito eliminado correctamente");
        }
    }

    @Override
    public ResponseEntity<ApiResponse<List<ShoppingCart>>> findAll() {
        List<ShoppingCart> shoppingCartList = shoppingCartRepository.findAll();
        if (shoppingCartList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse<>("No hay ningun Carrito creado",null));
        }
        else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse<>("Carritos encontrados",shoppingCartList));
        }
    }

    @Override
    public ResponseEntity<ApiResponse<ShoppingCart>> findById(Long id) {
        return shoppingCartRepository.findById(id)
                .map(shoppingCart -> ResponseEntity.status(HttpStatus.OK)
                        .body(new ApiResponse<>("Carrito con Id " + id + " encontrado correctamente"
                                ,shoppingCart)))
                .orElseGet(()-> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ApiResponse<>("El carrito con Id " + id + " no se encontro",null)));
    }

    @Override
    public ResponseEntity<ApiResponse<ShoppingCart>> update(ShoppingCartDto shoppingCartDto, Long id) {
        return null;
    }
}
