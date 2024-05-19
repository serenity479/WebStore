package com.company.controller;

import com.company.dto.Category;
import com.company.dto.Product;
import com.company.service.ProductsService;
import com.company.service.impl.ProductsServiceImpl;
import com.company.manager.SessionUserManager;
import com.company.soap.client.ProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductsController {


    @Autowired
    private ProductsService productsService;

    @Autowired
    private SessionUserManager userManager;

    @Autowired
    private ProductClient productClient;





    @PostMapping("/addCategory")
    public ModelAndView addCategoty(ModelAndView modelAndView, Category category, @RequestParam("name")String name){
        category.setName(name);
        productsService.addCategory(category); // добавим в базу
        modelAndView.addObject("ProductsCategory", productsService.getCategories()); // берем из базы, чтоб вывести во view
        modelAndView.setViewName("main_admin");
        return modelAndView;
    }

    @PostMapping("/addProduct")
    public ModelAndView addProduct(ModelAndView modelAndView, @ModelAttribute("addedProduct") Product addedProduct, HttpSession session){
        if(productsService.getProductById(addedProduct.getId()) != null){
            modelAndView.setViewName("redirect:/updateProduct"); // если такой продукт есть, то делаем обновление
            session.setAttribute("existingProduct", addedProduct);
            return modelAndView;
        }
        productsService.addProduct(addedProduct);
        modelAndView.setViewName("redirect:/main_admin");
        return modelAndView;
    }

    @GetMapping("/updateProduct")
    public String updateProduct(@RequestParam(required=false) Product updateProduct, ModelAndView modelAndView, HttpSession session){
        Product addedProduct = (Product)session.getAttribute("existingProduct");
        Integer id = addedProduct.getId();
        productsService.updateProduct(id, addedProduct);
        return "redirect:/main_admin";
    }


    @PostMapping("/deleteProduct")
    public ModelAndView deleteProduct(@RequestParam(required=false) Integer id, ModelAndView modelAndView){
        if (productsService.getProductById(id) != null) {
            productsService.delete(id); // productsService.getProductById(id)
        }
        modelAndView.setViewName("redirect:/main_admin");
        return modelAndView;
    }


    // это можно к поиску по id отнести
    @PostMapping("/findById")
    public ModelAndView getProduct(@RequestParam("searchProduct") Integer searchProductId, ModelAndView modelAndView, HttpSession httpSession){
        Product product = productsService.findProductById(searchProductId);
        List<Product> foundProducts = new ArrayList<>(); // добавляем в список всегда один эл просто потому что в jsp идет обработка списка
        foundProducts.add(product);
        httpSession.setAttribute("foundProducts", foundProducts);
        modelAndView.setViewName("redirect:/main"); // если будем искать из под админа, то сработат Interceptor и перекинет на его страницу - результаты там тоже будут
        return modelAndView;
    }


    @PostMapping("/findByName")
    public ModelAndView findProductByName(@RequestParam("searchProduct") String searchProductName, ModelAndView modelAndView, HttpSession httpSession){
        List<Product> foundProducts = productsService.findProductByName(searchProductName);
        httpSession.setAttribute("foundProducts", foundProducts);
        modelAndView.setViewName("redirect:/main");
        return modelAndView;
    }

    @PostMapping("/findByCost")
    public ModelAndView findProductByCost(@RequestParam("searchProduct") Integer searchProductCost, ModelAndView modelAndView, HttpSession httpSession){
        List<Product> foundProducts = productsService.findProductByCost(searchProductCost);
        httpSession.setAttribute("foundProducts", foundProducts);
        modelAndView.setViewName("redirect:/main");
        return modelAndView;
    }


}
