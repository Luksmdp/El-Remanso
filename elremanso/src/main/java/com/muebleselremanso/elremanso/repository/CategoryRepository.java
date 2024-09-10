package com.muebleselremanso.elremanso.repository;

import com.muebleselremanso.elremanso.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
