package com.company.service;

import com.company.dto.Order;

public interface OrderedProductService {

    public void addToOrder(int productId, Order order);
}
