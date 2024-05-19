package com.company;

import com.company.repository.ProductsRepository;
import com.company.repository.impl.UsersRepositoryImpl;
import com.company.service.impl.ProductsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Initializer {

    @Autowired
    UsersRepositoryImpl usersRepositoryImpl;

    @Autowired
    ProductsServiceImpl productsService;

    @Autowired
    ProductsRepository productsRepository;

    @PostConstruct
    public void init(){
        productsRepository.clearCache(); // при каждом запуске будем очищать кэш
        usersRepositoryImpl.initiateUsersRepo();
        //productsService.generateProducts(); // сгенерируем секции с продуктами при первом запуске
    }
}
