package com.company.controller;

import com.company.enums.Role;
import com.company.exceptions.SuchUserExists;
import com.company.dto.User;
import com.company.service.OrderService;
import com.company.service.UserService;
import com.company.service.impl.OrderServiceImpl;
import com.company.manager.SessionUserManager;
import com.company.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @Autowired
    private SessionUserManager userManager;

    @Autowired
    private OrderService orderService;


    @GetMapping("register")
    public ModelAndView openRegisterPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("register");
        return modelAndView;
    }


    @PostMapping("register")
    public ModelAndView register(@Valid @ModelAttribute("user")User user, BindingResult result, HttpServletRequest request, HttpSession session, ModelAndView modelAndView) throws SuchUserExists {

        try {
            userService.checkExistanceOfUser(user.getLogin());
        } catch(SuchUserExists e){
            modelAndView.addObject("errorMsg", "Такой пользователь уже существует");
            modelAndView.setViewName("register"); // после этого страница заново прогрузится уже с сообщением об ошибке
            return modelAndView;
        }
        user.setRole(Role.USER); // регистрируем только пользователей, не админов
        userService.addUser(user);
        userManager.setCurrentUser(user); // и в менеджер тоже добавим
        orderService.addOrder(user); // нам нужно для каждого пользователя свой заказ

        modelAndView = new ModelAndView(); // можно возвращать строку с редиректом
        session.setAttribute("login", user.getLogin());
        modelAndView.setViewName("redirect:/main");
        return modelAndView;
    }
}
