package com.company.interceptors;

import com.company.soap.client.ProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class SoapInterceptor implements HandlerInterceptor {

    @Autowired
    private ProductClient productClient;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        testSoap();
        return false;
    }

    public void testSoap(){
        //productClient.addProduct();
        productClient.getProduct(23);
        productClient.updateProduct(23);
        productClient.deleteProduct(23);
    }


}
