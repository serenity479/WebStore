package com.company.rest;

import com.company.dto.Product;
import com.company.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RestController
public class MyRestController {

    @Autowired
    private ProductsService productsService;



    @RequestMapping("/getProductRest")
    public Product getProduct(@RequestParam("searchProduct") Integer searchProductId) {
        Product product = productsService.findProductById(searchProductId);
        return product;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/addProductRest")
    public void addProduct(@RequestBody Product addedProduct) {
        productsService.addProduct1(addedProduct);
    }


    @RequestMapping("/deleteProductRest")
    public void deleteProduct(@RequestParam("deleteProduct") Integer id) {
        productsService.delete(id);
    }




}
