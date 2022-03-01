package com.example.userservice_restapi.controller;

import com.example.userservice_restapi.dto.UserDto;
import com.example.userservice_restapi.exception.ErrorResponse;
import com.example.userservice_restapi.exception.UserNotFoundException;

import java.util.*;

import com.example.userservice_restapi.service.UserService;
import com.example.userservice_restapi.ui.UserRequestModel;
import com.example.userservice_restapi.ui.UserResponseModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class UserController {

	/*NOTES:
	 * 1. This class is basically the the designed rest api class
	 * 2. The model mapper is a jar file that is imported with the help of mvn repository
	 * 3. this mapper class is used for mapping a class into some defined class similar to type casting.
	 * 4. spring.h2.console.enabled=true
			spring.datasource.url=jdbc:h2:mem:testDB
			spring.datasource.username=sa
			spring.datasource.password=sa
			spring.h2.console.settings.web-allow-others=true
			
			4.1 The code written above is used to help the application to deployed
			4.2 It also helps the to create in memory database which is this an example of, similar to ram
			4.3 first of all you need to type run the application
			4.4 then you need to write on the web as http://localhost:9090/h2-console
			4.5 then jdbc:h2:mem:testDB in jdbc url and pass 
			4.6 then run sql commands
			4.7 This database is an in memory database therefore we don't connect it with the mysql workbench
		
		*5. The @RequestBody annotation is used to request the body from the place where this post method 
		*	is being called. As the request body is of type of UserRequestModel therefore we need to send the
		*	data as per the format of UserrequestModel from the Postman. 
		*
		*6. The ResponseEntity that we see here is used to create response like status codes when we request
		*	a method call.
		*
		*FLOW OF APP
		*1. create use sis called by postman
		*2. then this ureqModel is what we get
		*3. then as id needs to be generated therefore UserDto is called to inject
		*4. then save method of service is called 
		*5. then as service calls the method of repo that actully provides the method to save the obj.
		*6. then as reponse needs to be generated then converted to userresmodel.
		*
		*/
    private final ModelMapper modelMapper;
    private final UserService userService;
    
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleError(UserNotFoundException e)
    {
        ErrorResponse errorResponse=new ErrorResponse();
        errorResponse.setErrorMessage(e.getMessage());
        errorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
        errorResponse.setErrorReportingTime(System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    public UserController(ModelMapper modelMapper, UserService userService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
    }
    

    @PostMapping("/users")
    public ResponseEntity<UserResponseModel> createUser(@RequestBody UserRequestModel userRequestModel)
    {
    	/*This model mapper is used to matching here */
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        
        /*Here we are converting it to UserDto type as with help of model mapper and also because 
         * User data from postman is of userRequestModel type but as id is being generated in the userDto
         * therefore we use userDto obj to inject the val for id therefore we convert it to userDto.
         * Then as we need to return the value as UserResponseModel therefore using mapper to convert to the req
         * class and then returning.*/
        UserDto userDto=modelMapper.map(userRequestModel,UserDto.class);
        userDto.setUserId(UUID.randomUUID().toString());
        userDto=userService.createUser(userDto);
        
        /*Here we are using userResponseModel as user need to only see his essentials removing the password*/
        return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(userDto,UserResponseModel.class));
    }
    
    @GetMapping("/users")
    public ResponseEntity<List<UserResponseModel>> getUsers()
    {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<UserResponseModel> list=new ArrayList<>();
        List<UserDto> dtos=userService.getUsers();
        for (UserDto d:dtos)
        {
            list.add(modelMapper.map(d,UserResponseModel.class));
        }
        return ResponseEntity.ok(list);
    }
    
    @GetMapping("/users/{userId}")
    public ResponseEntity<UserResponseModel> findUserByUserId(@PathVariable("userId") String userId)
    {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        if(userService.findUserByUserId(userId)==null)
        {
        	throw new UserNotFoundException("The user with id "+userId+" not found.");
        }
        return ResponseEntity.ok(modelMapper.map(userService.findUserByUserId(userId),UserResponseModel.class));
    }
    
    
    @DeleteMapping("/users/{userId}")
    public String deleteEmployee(@PathVariable("userId") String id)
    {
//    	if(userService.deleteUserByUserId(id)==null)
//    	{
//            throw new UserNotFoundException("employee with given id "+id+ " is not found");
//
//    	}
//    	else
    		userService.deleteUserByUserId(id);
        
    	return "deletion successful";
    }
    
    
    @PutMapping("/users/userId/{userId}")
    public ResponseEntity<UserResponseModel> updateUser(@RequestBody UserRequestModel userRequestModel,@PathVariable("userId") String userId)
    {
    	modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
//    	if(userService.findUserByUserId(userId)==null)
//    	{
//            throw new UserNotFoundException("employee with given id "+userId+ " is not found");
//    	}
    	
        return ResponseEntity.ok(modelMapper.map(userService.updateEmployeeByUserId(userRequestModel,userId),UserResponseModel.class));
    }
    
    
    @PutMapping("/users/email/{email}")
    public ResponseEntity<UserResponseModel> updateUserByEmail(@RequestBody UserRequestModel userRequestModel,@PathVariable("email") String email)
    {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.updateUserByEmail(userRequestModel,email));
    }
    
    
    @DeleteMapping("/users/email/{email}")
    public String deleteUserByEmail(@PathVariable("email") String email)
    {
//    	if(userService.deleteUserByUserId(id)==null)
//    	{
//            throw new UserNotFoundException("employee with given id "+id+ " is not found");
//
//    	}
//    	else
    		userService.deleteUserByEmail(email);
        
    	return "deletion successful";
    }
    
    
}