package com.example.couponservice;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.example.couponservice.entity.CouponEntity;
import com.example.couponservice.repo.CouponRepository;

@SpringBootApplication
@EnableEurekaClient
public class CouponServiceApplication implements CommandLineRunner{

	private final CouponRepository couponRepository;

    public CouponServiceApplication(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }
    
	public static void main(String[] args) {
		SpringApplication.run(CouponServiceApplication.class, args);
	}
	
	@Bean
    public ModelMapper modelMapper()
    {
        return new ModelMapper();
    }

	@Override
    public void run(String... args) throws Exception {
       couponRepository.save(new CouponEntity(1, UUID.randomUUID().toString(),10.5));
       couponRepository.save(new CouponEntity(2, UUID.randomUUID().toString(),20.0));
       couponRepository.save(new CouponEntity(3, UUID.randomUUID().toString(),5.3));
       couponRepository.save(new CouponEntity(4, UUID.randomUUID().toString(),27.4));

    }

}
