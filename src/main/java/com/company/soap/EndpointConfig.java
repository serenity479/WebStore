package com.company.soap;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

@Configuration
public class EndpointConfig {

    @Autowired
    private Bus bus;


    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint =
                new EndpointImpl(bus, new ProductServiceSoapImpl());
        endpoint.publish("/ProductService");

        return endpoint;
    }
}
