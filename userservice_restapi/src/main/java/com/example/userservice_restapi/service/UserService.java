package com.example.userservice_restapi.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.userservice_restapi.dto.UserDto;
import com.example.userservice_restapi.ui.UserRequestModel;
import com.example.userservice_restapi.ui.UserResponseModel;

public interface UserService {

    public UserDto createUser(UserDto userDto);
    public List<UserDto> getUsers();
    public UserDto findUserByUserId(String userId);
    public void deleteUserByUserId(String userId);
	public UserDto updateEmployeeByUserId(UserRequestModel userRequestModel, String userId);
	public UserResponseModel updateUserByEmail(UserRequestModel userRequestModel, String email);
	public void deleteUserByEmail(String email);
}