package com.company.service.impl;

import com.company.repository_spring_data.OrderRepository;
import com.company.dto.Order;
import com.company.dto.User;
import com.company.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;


    public void addOrder(User user){
        Order order = new Order();
        order.setUser(user);
        user.setOrder(order);
        orderRepository.save(order); // сохраним order под именем пользователя и со своим id
    }

    public void deleteOrder(Order order){
        orderRepository.delete(order);
    }

    public void updateOrder(Order order){
        orderRepository.save(order);
    }








}
