package com.example.userservice_restapi.service;

import com.example.userservice_restapi.dto.UserDto;
import com.example.userservice_restapi.entity.UserEntity;
import com.example.userservice_restapi.exception.UserNotFoundException;
import com.example.userservice_restapi.repo.UserRepository;
import com.example.userservice_restapi.ui.UserRequestModel;
import com.example.userservice_restapi.ui.UserResponseModel;

import java.util.*;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserEntity userEntity=modelMapper.map(userDto,UserEntity.class);
        StringBuilder stringBuilder=new StringBuilder(userDto.getPassword());
        userEntity.setEncryptedPassword(stringBuilder.reverse().toString());
        userEntity=userRepository.save(userEntity);
        return modelMapper.map(userEntity,UserDto.class);
    }
    
    @Override
    public List<UserDto> getUsers() {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
       List<UserDto> list=new ArrayList<>();
        Iterable<UserEntity> iterable= userRepository.findAll();
       Iterator<UserEntity> iterator= iterable.iterator();
       while (iterator.hasNext())
       {
           list.add(modelMapper.map(iterator.next(),UserDto.class));
       }
        return list;
    }

    @Override
    public UserDto findUserByUserId(String userId) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
       UserEntity userEntity= userRepository.findByUserId(userId);
       if(userEntity==null)
       {
       	throw new UserNotFoundException("The user with id "+userId+" not found.");
       }
        return modelMapper.map(userEntity,UserDto.class);
    }

    //@Transactional we can write transactional or we cannt it will work
	@Override
	public void deleteUserByUserId(String userId) {
		// TODO Auto-generated method stub
        //modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		if(userRepository.findByUserId(userId)==null)
    	{
            throw new UserNotFoundException("user with given id "+userId+ " is not found");

    	}
    	else
    	{
    		UserEntity userEntity=userRepository.findByUserId(userId);
    		userRepository.delete(userEntity);
    		
    		
    	}
    		//userRepository.deleteByUserId(userId);
    		
    		
		
	}

	@Override
	public UserDto updateEmployeeByUserId(UserRequestModel userRequestModel, String userId) {
		// TODO Auto-generated method stub
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserEntity userEntity=userRepository.findByUserId(userId);
		if(userEntity==null)
    	{
            throw new UserNotFoundException("employee with given id "+userId+ " is not found");
    	}
		userEntity.setFirstName(userRequestModel.getFirstName());
		userEntity.setLastName(userRequestModel.getLastName());
		userEntity.setEmail(userRequestModel.getEmail());
		
		StringBuilder stringBuilder=new StringBuilder(userRequestModel.getPassword());
        userEntity.setEncryptedPassword(stringBuilder.reverse().toString());
        userEntity=userRepository.save(userEntity);
		
		return modelMapper.map(userEntity,UserDto.class);
	}
	
	private UserEntity findUserByEmail(String email)
    {
        UserEntity userEntity=userRepository.findByEmail(email);
        return userEntity;
    }
	
	
	@Override
    public UserResponseModel updateUserByEmail(UserRequestModel userRequestModel, String email) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserEntity entity=findUserByEmail(email);
        if (entity==null)
        {
            throw new UserNotFoundException("user with email "+email+" not found");
        }
        entity.setFirstName(userRequestModel.getFirstName());
        entity.setLastName(userRequestModel.getLastName());
        entity.setEmail(userRequestModel.getEmail());
//        StringBuilder stringBuilder=new StringBuilder(userRequestModel.getPassword());
//        entity.setEncryptedPassword(stringBuilder.reverse().toString());
        userRepository.save(entity);
        return modelMapper.map(entity,UserResponseModel.class);
    }

	@Override
	public void deleteUserByEmail(String email) {
		 UserEntity entity=findUserByEmail(email);
	     if (entity==null)
	     {
	    	 throw new UserNotFoundException("user with email "+email+" not found");
	     }
	     
	     userRepository.delete(entity);
	}
    
    
}