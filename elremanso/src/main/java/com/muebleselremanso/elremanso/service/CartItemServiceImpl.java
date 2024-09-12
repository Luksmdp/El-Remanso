package com.muebleselremanso.elremanso.service;

import com.muebleselremanso.elremanso.model.dto.ApiResponse;
import com.muebleselremanso.elremanso.model.dto.CartItemDto;
import com.muebleselremanso.elremanso.model.entity.CartItem;
import com.muebleselremanso.elremanso.model.entity.Product;
import com.muebleselremanso.elremanso.model.entity.ShoppingCart;
import com.muebleselremanso.elremanso.repository.CartItemRepository;
import com.muebleselremanso.elremanso.repository.ProductRepository;
import com.muebleselremanso.elremanso.repository.ShoppingCartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartItemServiceImpl implements CartItemService{

    private final CartItemRepository cartItemRepository;
    private final ShoppingCartRepository shoppingCartRepository;
    private final ProductRepository productRepository;
    @Override
    public ResponseEntity<ApiResponse<CartItem>> save(CartItemDto cartItemDto) {
        Optional<ShoppingCart> shoppingCartOptional = shoppingCartRepository.findById(cartItemDto.getShoppingCartId());
        Optional<Product> productOptional = productRepository.findById(cartItemDto.getProductId());

        if (shoppingCartOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse<>("El Id del Carrito no existe",null));
        }
        if (productOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse<>("El Id del Producto no existe",null));
        }
        CartItem cartItem = CartItem.builder()
                .quantity(cartItemDto.getQuantity())
                .subtotal(cartItemDto.getSubtotal())
                .shoppingCart(shoppingCartOptional.get())
                .product(productOptional.get())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>("Item Carrito creado correctamente"
                        ,cartItemRepository.save(cartItem)));
    }

    @Override
    public ResponseEntity<String> delete(Long id) {
        Optional<CartItem> cartItemOptional = cartItemRepository.findById(id);
        if (cartItemOptional.isEmpty())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Item Carrito no encontrado");
        }
        else {
            cartItemRepository.delete(cartItemOptional.get());
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Item Carrito eliminado correctamente");
        }
    }

    @Override
    public ResponseEntity<ApiResponse<List<CartItem>>> findAll() {

        List<CartItem> cartItemList = cartItemRepository.findAll();
        if (cartItemList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse<>("No se encontraron Items Carrito",null));
        }
        else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse<>("Items Carrito encontrados",cartItemList));
        }
    }

    @Override
    public ResponseEntity<ApiResponse<CartItem>> findById(Long id) {
        return cartItemRepository.findById(id)
                .map(cartItem -> ResponseEntity.status(HttpStatus.OK)
                        .body(new ApiResponse<>("Item Carrito encontrado",cartItem)))
                .orElseGet(()-> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ApiResponse<>("Item Carrito con Id " + id + " no encontrado",null)));
    }

    @Override
    public ResponseEntity<ApiResponse<CartItem>> update(CartItemDto cartItemDto, Long id) {
        return null;
    }
}
