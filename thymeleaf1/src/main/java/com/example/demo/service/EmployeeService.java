package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Employee;

public interface EmployeeService {
	public Employee createEmployee(Employee customer);
	
	public List<Employee> getAllEmployee();
	
	public Employee getEmployee(Integer id);
	
	public void deleteEmployee(Integer id);

}
