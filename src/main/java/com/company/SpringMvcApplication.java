package com.company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableCaching
public class SpringMvcApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringMvcApplication.class, args);
	}

	@Bean
	public RestTemplate geRestTemplate() {
		return new RestTemplate();
	}

}
