package com.company.soap.client;


import com.company.soap.ProductServiceSoap;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration 
public class ClientConfig {

    @Value("${client.ticketagent.address}")
    private String address;


    @Bean(name = "productProxy")
    public ProductServiceSoap greetingServiceProxy() {
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean =
                new JaxWsProxyFactoryBean();

        jaxWsProxyFactoryBean.setServiceClass(ProductServiceSoap.class);
        jaxWsProxyFactoryBean.setAddress(address);

        return (ProductServiceSoap) jaxWsProxyFactoryBean.create();
    }
}
