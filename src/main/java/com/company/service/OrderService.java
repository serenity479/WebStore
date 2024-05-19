package com.company.service;

import com.company.dto.Order;
import com.company.dto.User;

public interface OrderService {

    public void addOrder(User user);

    public void deleteOrder(Order order);

    public void updateOrder(Order order);

}
