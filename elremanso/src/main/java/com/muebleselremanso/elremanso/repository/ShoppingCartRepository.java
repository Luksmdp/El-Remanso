package com.muebleselremanso.elremanso.repository;

import com.muebleselremanso.elremanso.model.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Long> {
}
