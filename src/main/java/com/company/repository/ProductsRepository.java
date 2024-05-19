package com.company.repository;

import com.company.dto.Category;
import com.company.dto.Product;

import java.util.ArrayList;
import java.util.List;

public interface ProductsRepository {


    public void addProduct(Product product);

    public void delete(Integer id); // Product product

    public void update(Integer id, Product updateproduct);

    public Product findById(Integer id);

    public List<Product> findByName(String name);

    public List<Product> findByCost(Integer cost);

    public void clearCache();




}
