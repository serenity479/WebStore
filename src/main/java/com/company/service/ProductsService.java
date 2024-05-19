package com.company.service;

import com.company.dto.Category;
import com.company.dto.Product;


import java.util.List;

public interface ProductsService {


    public void addCategory(Category category);

    public List<Category> getCategories();

    public void addProduct(Product product);

    public void addProduct1(Product product);

    public Product getProductById(Integer id);

    public void updateProduct(Integer id, Product updateProduct);

    public void delete(Integer id); // Product product

    public Product findProductById(Integer id);

    public List<Product> findProductByName(String wantedProductName);

    public List<Product> findProductByCost(int wantedProductCost);
}
