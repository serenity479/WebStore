package com.company.repository.impl;

import com.company.dto.Order;
import com.company.repository.OrdersRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class OrdersRepositoryImpl implements OrdersRepository{

    @PersistenceContext
    private EntityManager entityManager;

    public void add(Order order) {
        entityManager.persist(order);
    }

    public void delete(Order order) {
        entityManager.remove(order);
    }







}
