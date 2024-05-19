package com.company.soap.client;

import com.company.dto.Product;
import com.company.service.ProductsService;
import com.company.soap.ProductServiceSoap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ProductClient {

    @Autowired
    @Qualifier("productProxy")
    private ProductServiceSoap productProxy;

    @Autowired
    private ProductsService productsService;

    private Logger logger = LoggerFactory.getLogger(ProductClient.class);


    public void addProduct(){
        Product product = new Product();
        product.setId(401);
        product.setImg("src/main/webapp/img/no-image-found.jpg"); product.setName("Лампочка 60W"); product.setCost(1800);
        product.setCategory(productsService.getCategories().get(4));
        String response = productProxy.addProduct(product);
        logger.info(response);
    }

    public void getProduct(Integer id){
        Product product = productProxy.getProduct(id);
        logger.info("Продукт" + product.getName() + "получен");
    }

    public void updateProduct(Integer id){
        Product updatedProduct = new Product(id, "src/main/webapp/img/update-product.jpg", "newName", 1200);
        productProxy.updateProduct(id, updatedProduct);
    }

    public void deleteProduct(Integer id){
        productProxy.deleteProduct(id);
    }




}
