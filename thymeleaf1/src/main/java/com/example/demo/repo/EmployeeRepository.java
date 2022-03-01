package com.example.demo.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;


// this JpaRepository that takes place of session factory beans 
// this does the work of Session Factory bean and has predefined method implemented in its base class 
// which we can use 
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
}
