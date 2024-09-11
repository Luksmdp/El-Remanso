package com.muebleselremanso.elremanso.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class ShoppingCartDto {

    @NotNull(message = "El total es obligatorio")
    @PositiveOrZero(message = "El total debe ser mayor o igual a 0")
    private Double total;
}
