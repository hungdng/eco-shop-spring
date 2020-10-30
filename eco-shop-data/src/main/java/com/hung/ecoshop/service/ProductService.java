package com.hung.ecoshop.service;

import com.hung.ecoshop.entity.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ProductService {

    ProductInfo findOne(UUID productId);

    // All selling products
    Page<ProductInfo> findUpAll(Pageable pageable);

    // All products
    Page<ProductInfo> findAll(Pageable pageable);

    // All products in a category
    Page<ProductInfo> findAllInCategory(Integer categoryType, Pageable pageable);

    ProductInfo update(ProductInfo productInfo);

    ProductInfo save(ProductInfo productInfo);

    void delete(String productId);
}
