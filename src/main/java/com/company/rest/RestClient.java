package com.company.rest;

import com.company.dto.Product;
import com.company.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component("restClient")
public class RestClient {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProductsService productsService;

    public Product getProduct() {
        return restTemplate.getForObject("http://localhost:8080/getProductRest?searchProduct=10", Product.class);
    }

    public String addProduct(){
        Product product = new Product();
        product.setId(404);
        product.setImg("src/main/webapp/img/no-image-found.jpg"); product.setName("Лампочка 60W"); product.setCost(900);
        product.setCategory(productsService.getCategories().get(2));
        restTemplate.postForObject("http://localhost:8080/addProductRest", product, ResponseEntity.class);
        return "OK";
    }

    public String deleteProduct(){
        restTemplate.getForObject("http://localhost:8080/deleteProductRest?deleteProduct=12", String.class);
        return "OK";
    }





}
