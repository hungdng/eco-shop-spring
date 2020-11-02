package com.hung.ecoshop.repository;

import com.hung.ecoshop.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, UUID> {
    // Some category
    List<ProductCategory> findByCategoryTypeInOrderByCategoryTypeAsc(List<Integer> categoryTypes);

    // All category
    List<ProductCategory> findAllByOrderByCategoryType();

    // One category
    ProductCategory findByCategoryType(Integer categoryType);
}
