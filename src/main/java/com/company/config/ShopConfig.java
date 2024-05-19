package com.company.config;

import com.company.interceptors.AdminInterceptor;
import com.company.interceptors.AuthInterceptor;
import com.company.interceptors.CommonUserInterceptor;
import com.company.interceptors.SoapInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@Import({})
public class ShopConfig implements WebMvcConfigurer{

    @Autowired
    private AuthInterceptor authInterceptor;
    @Autowired
    private AdminInterceptor adminInterceptor;
    @Autowired
    private CommonUserInterceptor commonUserInterceptor;
    @Autowired
    private SoapInterceptor soapInterceptor;



    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(authInterceptor)
        .addPathPatterns("/**", "/", "")
        .excludePathPatterns("/auth", "/main", "/soap", "/getProductRest", "/addProductRest", "/deleteProductRest", "updateProductRest" ,"/register", "/logout" ,"/css/**", "/js/**");
        registry.addInterceptor(adminInterceptor)
                .addPathPatterns("/main_admin", "/main_admin/**");
        registry.addInterceptor(commonUserInterceptor)
                .addPathPatterns("/main", "/main/**");
        registry.addInterceptor(soapInterceptor)
                .addPathPatterns("/soap");

    }

}
