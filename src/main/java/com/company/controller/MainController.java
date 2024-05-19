package com.company.controller;

import com.company.dto.Order;
import com.company.service.OrderedProductService;
import com.company.service.ProductsService;
import com.company.service.impl.OrderServiceImpl;
import com.company.service.impl.OrderedProductServiceImpl;
import com.company.service.impl.ProductsServiceImpl;
import com.company.manager.SessionUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class MainController {

    @Autowired
    private ProductsService productsService;

    @Autowired
    private OrderServiceImpl orderService;

    @Autowired
    private OrderedProductService orderedProductService;


    @Autowired
    private SessionUserManager userManager;

    @GetMapping("/main")
    public ModelAndView loadProducts(HttpSession session, ModelAndView modelAndView) {
        modelAndView.addObject("ProductsCategory", productsService.getCategories());
        modelAndView.addObject("userRole", session.getAttribute("userRole"));
        modelAndView.addObject("login", session.getAttribute("login")); // положим из сессии в модель
        modelAndView.setViewName("main");
        return modelAndView;
    }

    @GetMapping("/main_admin")
    public ModelAndView loadProductsForAdmin(HttpSession session, ModelAndView modelAndView){

        modelAndView.addObject("ProductsCategory", productsService.getCategories());
        //modelAndView.addObject("userRole", session.getAttribute("userRole"));
        modelAndView.addObject("login", session.getAttribute("login")); // положим из сессии в модель
        modelAndView.addObject("foundProducts", session.getAttribute("foundProducts"));
        modelAndView.setViewName("main_admin");
        return modelAndView;
    }

    @GetMapping("/logout")
    public void logout(ModelAndView modelAndView, HttpSession session){
        session.invalidate();
        userManager.setCurrentUser(null);
    }

    @RequestMapping(value = "/addToOrder/{id}")
    public ModelAndView addToBasket(@PathVariable(value = "id") Integer id, ModelAndView modelAndView){

        Order currentUserOrder = userManager.getCurrentUser().getOrder();
        orderedProductService.addToOrder(id, currentUserOrder);
        modelAndView.setViewName("redirect:/main");
        return modelAndView;

    }

}
