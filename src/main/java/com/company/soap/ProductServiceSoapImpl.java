package com.company.soap;


import com.company.dto.Product;
import com.company.repository.ProductsRepository;
import com.company.repository.impl.ProductsRepositoryImpl;
import com.company.repository.impl.ProductsRepositoryJdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceSoapImpl implements ProductServiceSoap {

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private ProductsRepositoryImpl productsRepositoryImpl;



    @Override
    public String addProduct(Product product) {
        productsRepositoryImpl.addProduct(product);
        return "OK";
    }

    @Override
    public Product getProduct(Integer id) {
        Product product = productsRepository.findById(id);
        return product;
    }

    @Override
    public String updateProduct(Integer id, Product updatedProduct) {
        productsRepository.update(id, updatedProduct);
        return "OK";
    }

    @Override
    public String deleteProduct(Integer id) {
        productsRepository.delete(id);
        return "OK";
    }
}
