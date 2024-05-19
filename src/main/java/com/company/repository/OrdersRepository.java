package com.company.repository;

import com.company.dto.Order;

public interface OrdersRepository {

    public void add(Order order);

    public void delete(Order order);
}
