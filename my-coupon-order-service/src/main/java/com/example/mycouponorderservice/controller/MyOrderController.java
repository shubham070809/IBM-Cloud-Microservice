package com.example.mycouponorderservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.mycouponorderservice.model.Coupon;


/*Notes 
 * 1. This is an example of using micro services
 * 2. Microservices are nothing but application or java code running
 * 3. Microservices here are of two type that is Server type and client type
 * 4. Here the server microservice is discovery micro service
 * 5. The client micro service here is my order service and coupon service
 * 6. earlier in the example of eureka service held the client microservice named customer service and order
 * 7. They were running independently but were attached to the main server service
 * 8. Here also they are running independently but has some portion of them communicating with each other*/

@RestController
public class MyOrderController {
	
	private final RestTemplate restTemplate;

	public MyOrderController(RestTemplate restTemplate) {
		
		this.restTemplate = restTemplate;
	}
	
	@GetMapping("/orders/{code}")
	public Coupon getCoupon(@PathVariable("code")String code)
	{	
		// Code for communicating with the app running on the 172.18.10.38 on port 8081 
		Coupon coupon=restTemplate.getForObject("http://172.18.10.38:8081/couponsByCode/"+code, Coupon.class);
		return coupon;
	}
}
