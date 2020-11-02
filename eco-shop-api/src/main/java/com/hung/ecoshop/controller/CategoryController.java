package com.hung.ecoshop.controller;

import com.hung.ecoshop.entity.ProductCategory;
import com.hung.ecoshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
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
        if (productCategory.getId() != null) return ResponseEntity.badRequest().build();
//        boolean categoryIdExists =categoryService.isExists(productCategory.getId());
//        if (categoryIdExists) {
//            bindingResult.rejectValue("id", "error.productCategory",
//                    "There is already a product with the code provided");
//        }
        if (bindingResult.hasErrors()){
            return ResponseEntity.badRequest().body(bindingResult);
        }
        return ResponseEntity.ok(categoryService.save(productCategory));
    }
}
