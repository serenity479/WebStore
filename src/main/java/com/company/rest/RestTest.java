package com.company.rest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class RestTest {

    @Autowired
    RestClient restClient;


    @Test
    public void testAddProduct() {
        restClient.addProduct();
    }

    @Test
    public void testGetProduct() {
        restClient.getProduct();
    }

    @Test
    public void deleteProduct() {
        restClient.deleteProduct();
    }

}
