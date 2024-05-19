package com.company.service.impl;


import com.company.repository_spring_data.OrderRepository;
import com.company.repository_spring_data.OrderedRepository;
import com.company.repository_spring_data.ProductRepository;
import com.company.dto.Order;
import com.company.dto.OrderedProduct;
import com.company.dto.Product;
import com.company.service.OrderedProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderedProductServiceImpl implements OrderedProductService{

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderedRepository orderedRepository;

    @Autowired
    private ProductRepository productRepository;

    public void addToOrder(int productId, Order order) { //  для одного заказа получается несколько продуктов

        Product product = productRepository.findById(productId).get(); // по id шнику найдем продукт
        OrderedProduct orderedProduct = new OrderedProduct(order, product);
        orderedRepository.save(orderedProduct);
    }

}
