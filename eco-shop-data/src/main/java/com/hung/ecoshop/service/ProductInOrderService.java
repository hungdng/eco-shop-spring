package com.hung.ecoshop.service;

import com.hung.ecoshop.entity.ProductInOrder;
import com.hung.ecoshop.entity.User;

public interface ProductInOrderService {
    void update(String itemId, Integer quantity, User user);
    ProductInOrder findOne(String itemId, User user);
}
