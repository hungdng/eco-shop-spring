package com.hung.ecoshop.seedData;

import com.hung.ecoshop.entity.ProductCategory;
import com.hung.ecoshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;

@Component
public class DataLoader implements CommandLineRunner {

    private final CategoryService categoryService;

    public DataLoader(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = categoryService.findAll().size();
        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        ProductCategory productCategory = ProductCategory
                                            .builder()
                                            .categoryName("Category 1")
                                            .categoryType(1)
                                            .build();
        categoryService.save(productCategory);
    }
}
