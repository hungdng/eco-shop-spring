package com.hung.ecoshop.controller;

import com.hung.ecoshop.entity.ProductInfo;
import com.hung.ecoshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public Page<ProductInfo> findAll(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                     @RequestParam(value = "size", defaultValue = "3") Integer size) {
        PageRequest request = PageRequest.of(page - 1, size);
        return productService.findAll(request);
    }

    @GetMapping("/{productId}")
    public ProductInfo showOne(@PathVariable("productid") String productId){
        return productService.findOne(productId);
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody ProductInfo product, BindingResult bindingResult){
        ProductInfo productIdExists = productService.findOne(product.getProductId());
        if (productIdExists != null) {
            bindingResult.rejectValue("productId", "error.product",
                    "There is already a product with the code provided");
        }
        if (bindingResult.hasErrors()){
            return ResponseEntity.badRequest().body(bindingResult);
        }
        return ResponseEntity.ok(productService.save(product));
    }
}
