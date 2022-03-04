package com.example.employeeservice.service;

import java.util.List;

import com.example.employeeservice.dto.Dto;
import com.example.employeeservice.model.Employee;
import com.example.employeeservice.ui.RequestModel;

public interface EmployeeService {
	
	public Dto createEmployee(Employee employee);
	public List<Dto> getAllEmployees();
	public Dto getByEmployeeUniqueId(String uniqueEmployeeId);
	public Dto updateEmployee(RequestModel requestModel,String uniqueEmployeeId);
	public void deleteEmployee(String uniqueEmployeeId);

}
