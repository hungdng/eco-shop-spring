package com.hung.ecoshop.service.impl;


import com.hung.ecoshop.entity.ProductInfo;
import com.hung.ecoshop.enums.ProductStatusEnum;
import com.hung.ecoshop.enums.ResultEnum;
import com.hung.ecoshop.exception.MyException;
import com.hung.ecoshop.repository.ProductInfoRepository;
import com.hung.ecoshop.service.CategoryService;
import com.hung.ecoshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Autowired
    private CategoryService categoryService;

    @Override
    public ProductInfo findOne(UUID productId) {

        ProductInfo productInfo = productInfoRepository.findById(productId).orElse(null);
        return productInfo;
    }

    @Override
    public Page<ProductInfo> findUpAll(Pageable pageable) {
//        return productInfoRepository.findAllByProductStatusOrderByIdAsc(ProductStatusEnum.UP.getValue(),pageable);
        return null;
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return productInfoRepository.findAllByOrderById(pageable);
    }

    @Override
    public Page<ProductInfo> findAllInCategory(String categoryType, Pageable pageable) {
//        return productInfoRepository.findAllByCategoryTypeOrderByIdAsc(categoryType, pageable);
        return null;
    }

    @Override
    public ProductInfo update(ProductInfo productInfo) {

        // if null throw exception
//        categoryService.findByCategoryType(productInfo.getCategoryType());
//        if(productInfo.getProductStatus() > 1) {
//            throw new MyException(ResultEnum.PRODUCT_STATUS_ERROR);
//        }
//        return productInfoRepository.save(productInfo);
        return null;
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return update(productInfo);
    }

    @Override
    public void delete(String productId) {
        ProductInfo productInfo = findOne(UUID.fromString(productId));
        if (productInfo == null) throw new MyException(ResultEnum.PRODUCT_NOT_EXIST);
        productInfoRepository.delete(productInfo);
    }
}
