package com.company.soap.client;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SpringCxfApplicationTests {

    @Autowired
    private ProductClient productClient;

    @Test
    public void testAddProduct() {
        productClient.addProduct();
    }

    @Test
    public void testGetProduct() {
        productClient.getProduct(23);
    }

    @Test
    public void testUpdateProduct() {
        productClient.updateProduct(23);
    }

    @Test
    public void testDeleteProduct() {
        productClient.deleteProduct(23);
    }


}
