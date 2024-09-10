package com.muebleselremanso.elremanso.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Double total;

    @OneToMany(mappedBy = "shoppingCart")
    private List<CartItem> cartItemList = new ArrayList<>();

    public void addCartItem(Product product,Integer quantity){
        double price = product.getPrice();

        if (product.getPromotionalPrice() > 0){
            price = product.getPromotionalPrice();
        }

        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(quantity);
        cartItem.setSubtotal(price * quantity);

        this.cartItemList.add(cartItem);
        this.total += cartItem.getSubtotal();
    }
}
