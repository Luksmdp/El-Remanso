package com.muebleselremanso.elremanso.repository;

import com.muebleselremanso.elremanso.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
