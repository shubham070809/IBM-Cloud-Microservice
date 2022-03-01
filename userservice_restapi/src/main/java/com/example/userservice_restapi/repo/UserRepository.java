package com.example.userservice_restapi.repo;


import com.example.userservice_restapi.entity.UserEntity;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

// this annotation is used to indicate that this the last layer managing data
// it is a type of compont but better functionality than component
@Repository

public interface UserRepository extends CrudRepository<UserEntity,Integer> {
    @Query
    public UserEntity findByUserId(String userId);
    
    
   // @Query
    //public void deleteByUserId(String user_id);
    
    @Query
    public UserEntity findByEmail(String email);
}