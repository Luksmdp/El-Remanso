package com.muebleselremanso.elremanso.repository;

import com.muebleselremanso.elremanso.model.entity.Category;
import com.muebleselremanso.elremanso.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findByCategoryAndPriceBetween(Category category, Double priceMin, Double priceMax);

}
