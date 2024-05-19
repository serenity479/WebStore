package com.company.controller;

import com.company.dto.User;
import com.company.enums.Role;
import com.company.exceptions.UserNotFound;
import com.company.exceptions.WrongPasswordException;
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
public class AuthController {

    @Autowired
    private SessionUserManager userManager;

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("auth")
    public ModelAndView openAuthPage(){
         ModelAndView modelAndView = new ModelAndView();
         modelAndView.setViewName("auth");
         return modelAndView; // после этого станица открывается
         //return "redirect:/auth";
    }


    @PostMapping("auth")
    public ModelAndView authenticate(@Valid @ModelAttribute("user")User user,
                                     BindingResult result, HttpServletRequest request,
                                     ModelAndView modelAndView, HttpSession session) throws UserNotFound, WrongPasswordException {
        try {
            userService.checkLoginAndPassword(user.getLogin(), user.getPassword());
        } catch (WrongPasswordException e) {
            modelAndView.addObject("errorMsg", "Неверный пароль");
            modelAndView.setViewName("auth"); // после этого страница заново прогрузится уже с сообщением об ошибке
            return modelAndView;
        } catch (UserNotFound userNotFound) {
            modelAndView.addObject("errorMsg", "Такого пользователя не существует");
            modelAndView.setViewName("auth");
            return modelAndView;
        }
        session.setAttribute("login", user.getLogin());

        User entireUser = userService.getUser(user.getLogin()); // получим пользоателя со всеми данными из базы
        if(entireUser.getRole() == Role.ADMINISTRATOR){ // админ может войти только через авторизацию
            modelAndView.setViewName("redirect:/main_admin");
            userManager.setCurrentUser(entireUser);
            return modelAndView;
        }
        modelAndView.setViewName("redirect:/main");
        userManager.setCurrentUser(entireUser);
        return modelAndView;
    }






}
