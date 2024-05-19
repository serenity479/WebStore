package com.company.interceptors;


import com.company.dto.User;
import com.company.enums.Role;

import com.company.manager.SessionUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AdminInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private SessionUserManager userManager;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{

        User user = userManager.getCurrentUser();

        if(user.getRole() != Role.ADMINISTRATOR){
            response.sendRedirect("main");
            return false;
        }

        return true;
    }


}
