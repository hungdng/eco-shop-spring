package com.hung.ecoshop.service;

import com.hung.ecoshop.entity.Cart;
import com.hung.ecoshop.entity.ProductInOrder;
import com.hung.ecoshop.entity.User;

import java.util.Collection;

public interface CartService {
    Cart getCart(User user);

    void mergeLocalCart(Collection<ProductInOrder> productInOrders, User user);

    void delete(String itemId, User user);

    void checkout(User user);
}
