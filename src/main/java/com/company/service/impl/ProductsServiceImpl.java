package com.company.service.impl;

import com.company.repository_spring_data.CategoryRepository;
import com.company.repository_spring_data.ProductRepository;
import com.company.dto.Category;
import com.company.dto.Product;
import com.company.repository.CategoriesRepository;
import com.company.repository.ProductsRepository;
import com.company.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    private ProductsRepository productsRepository; // hibernate, jdbcTemplate
    @Autowired
    private ProductRepository productRepository; // spring data
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoriesRepository categoriesRepository;




    public void addProduct1(Product product){
        productRepository.save(product);
    }

    public void addCategory(Category category){
        categoriesRepository.addCategory(category);
    }

    public List<Category> getCategories(){
        return categoryRepository.findAll();
    }


    public void addProduct(Product product){
        productsRepository.addProduct(product);
    }

    public void updateProduct(Integer id, Product updateProduct) {
        //productRepository.save(updateProduct);
        productsRepository.update(id, updateProduct);

    }

    public void delete(Integer id) { // Product product
        productsRepository.delete(id);
    }

    public Product getProductById(Integer id){
        if(productRepository.findById(id).isPresent()){
            return productRepository.findById(id).get();
        }else{
            return null;
        }
    }

    public Product findProductById(Integer id){
        return productsRepository.findById(id);
    }

    public List<Product> findProductByName(String nameOfWantedProduct){
        return productsRepository.findByName(nameOfWantedProduct);
    }

    public List<Product> findProductByCost(int costOfWantedProduct){
        return productsRepository.findByCost(costOfWantedProduct);
    }





}
