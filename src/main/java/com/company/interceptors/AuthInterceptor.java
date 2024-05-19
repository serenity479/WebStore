package com.company.interceptors;

import com.company.repository.impl.UsersRepositoryImpl;
import com.company.manager.SessionUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Autowired
    private SessionUserManager userManager;

    @Autowired
    private UsersRepositoryImpl usersRepositoryImpl;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        if(Objects.isNull(userManager.getCurrentUser())){ // Objects.isNull() userManager.getCurrentUser() == null

            response.sendRedirect("/auth");
            return false;
        }



        return true;
    }
}
