package com.hung.ecoshop.controller;

import com.hung.ecoshop.entity.ProductCategory;
import com.hung.ecoshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity findAll(){
        return ResponseEntity.ok(categoryService.findAll());
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody ProductCategory productCategory, BindingResult bindingResult){
//        ProductCategory categoryIdExists =categoryService.findOne(productCategory.getCategoryId());
//        if (categoryIdExists != null) {
//            bindingResult.rejectValue("categoryId", "error.productCategory",
//                    "There is already a product with the code provided");
//        }
        if (bindingResult.hasErrors()){
            return ResponseEntity.badRequest().body(bindingResult);
        }
        return ResponseEntity.ok(categoryService.save(productCategory));
    }
}
