package com.example.todoangular.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.todoangular.model.ToDo;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo,Integer>{

}
