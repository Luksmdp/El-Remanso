package com.muebleselremanso.elremanso.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class CartItemDto {

    @NotNull(message = "La cantidad es obligatoria")
    @Min(value = 1, message = "La cantidad debe ser al menos 1")
    private Integer quantity;
    @NotNull(message = "El subtotal es obligatorio")
    @PositiveOrZero(message = "El subtotal debe ser mayor o igual a 0")
    private Double subtotal;
    @NotNull(message = "El Id del Producto es obligatorio")
    private Long productId;
    @NotNull(message = "El Id del Carrito es obligatorio")
    private Long shoppingCartId;
}
