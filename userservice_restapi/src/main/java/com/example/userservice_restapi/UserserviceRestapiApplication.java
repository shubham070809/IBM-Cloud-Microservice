package com.example.userservice_restapi;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.userservice_restapi.entity.UserEntity;
import com.example.userservice_restapi.repo.UserRepository;

@SpringBootApplication
public class UserserviceRestapiApplication implements CommandLineRunner{

	
	private final UserRepository userRepository;

    public UserserviceRestapiApplication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
	public static void main(String[] args) {
		SpringApplication.run(UserserviceRestapiApplication.class, args);
	}
	
	@Bean
    public ModelMapper modelMapper()
    {
        return new ModelMapper();
    }

	@Override
    public void run(String... args) throws Exception {
       userRepository.save(new UserEntity(1, UUID.randomUUID().toString(),"John","Doe","john@email.com","tytyt"));
        userRepository.save(new UserEntity(2, UUID.randomUUID().toString(),"Marry","Public","marry@email.com","uyuyuuy"));
        userRepository.save(new UserEntity(3, UUID.randomUUID().toString(),"Daniel","Smith","daniel@email.com","uiyuyu"));
        userRepository.save(new UserEntity(4, UUID.randomUUID().toString(),"Sachin","Tendulkar","sachin@email.com","uiuj"));

    }
}
