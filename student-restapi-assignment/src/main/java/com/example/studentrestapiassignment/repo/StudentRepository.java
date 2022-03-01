package com.example.studentrestapiassignment.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.studentrestapiassignment.entity.Student;
import com.example.studentrestapiassignment.ui.StudentRequestModel;

@Repository
public interface StudentRepository extends CrudRepository<Student,Integer>{

}
