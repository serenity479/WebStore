package com.company.soap;

import com.company.dto.Product;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(serviceName = "ProductServiceSoap")
    public interface ProductServiceSoap {

        @WebMethod()
        @WebResult(name = "Product")
        public String addProduct(@WebParam Product product);

        @WebMethod()
        @WebResult(name = "Product")
        public Product getProduct(@WebParam Integer id);

        @WebMethod()
        @WebResult(name = "Product")
        public String updateProduct(@WebParam Integer id, @WebParam Product product);

        @WebMethod()
        @WebResult(name = "Product")
        public String deleteProduct(@WebParam Integer id);


    }

