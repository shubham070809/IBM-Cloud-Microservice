package com.example.mycouponorderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class MyCouponOrderServiceApplication {
// This application is connected with discovery service that is the main server 
	// discovery service coupon service my coupon order service are all connected together
	public static void main(String[] args) {
		SpringApplication.run(MyCouponOrderServiceApplication.class, args);
	}
	
	
	@Bean
	@Primary
	public RestTemplate restTemplate()
	{
		return new RestTemplate();
	}

}
