package com.hung.ecoshop.repository;

import com.hung.ecoshop.entity.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductInfoRepository extends JpaRepository<ProductInfo, UUID> {
//    ProductInfo findById(UUID id);

    // onsale product
    Page<ProductInfo> findAllByProductStatusOrderByIdAsc(Integer productStatus, Pageable pageable);

    // product in one category
    Page<ProductInfo> findAllByCategoryTypeOrderByIdAsc(Integer categoryType, Pageable pageable);

    Page<ProductInfo> findAllByOrderById(Pageable pageable);

}
