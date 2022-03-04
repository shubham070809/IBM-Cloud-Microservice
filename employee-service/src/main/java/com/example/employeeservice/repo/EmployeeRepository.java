package com.example.employeeservice.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.employeeservice.model.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee,Integer>{

	@Query
	public Employee findByEmployeeUniqueId(String uniqueEmployeeId);
	
}
