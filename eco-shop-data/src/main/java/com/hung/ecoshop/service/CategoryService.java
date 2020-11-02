package com.hung.ecoshop.service;

import com.hung.ecoshop.entity.ProductCategory;

import java.util.List;
import java.util.UUID;

public interface CategoryService {

    ProductCategory findOne(UUID categoryId);

    List<ProductCategory> findAll();

    ProductCategory findByCategoryType(Integer categoryType);

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);

    boolean isExists(UUID id);

}
