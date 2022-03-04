package com.example.employeeservice.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeeservice.dto.Dto;
import com.example.employeeservice.model.Employee;
import com.example.employeeservice.repo.EmployeeRepository;
import com.example.employeeservice.ui.RequestModel;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private final ModelMapper modelMapper;
	private final EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(ModelMapper modelMapper, EmployeeRepository employeeRepository) {
		super();
		this.modelMapper = modelMapper;
		this.employeeRepository = employeeRepository;
	}
	

	@Override
	public Dto createEmployee(Employee employee) {
		// TODO Auto-generated method stub
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        employee.setEmployeeId(new Random().nextInt());
        employee.setEmployeeUniqueId(UUID.randomUUID().toString());
        employeeRepository.save(employee);
        
		return modelMapper.map(employee,Dto.class);
	}

	

	@Override
	public List<Dto> getAllEmployees() {
		// TODO Auto-generated method stub
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	       List<Dto> list=new ArrayList<>();
	        Iterable<Employee> iterable= employeeRepository.findAll();
	       Iterator<Employee> iterator= iterable.iterator();
	       while (iterator.hasNext())
	       {
	           list.add(modelMapper.map(iterator.next(),Dto.class));
	       }
	        return list;
	}


	@Override
	public Dto getByEmployeeUniqueId(String uniqueEmployeeId) {
		// TODO Auto-generated method stub
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Employee employee=employeeRepository.findByEmployeeUniqueId(uniqueEmployeeId);
		
		return modelMapper.map(employee,Dto.class);
	}


	@Override
	public Dto updateEmployee(RequestModel requestModel, String uniqueEmployeeId) {
		// TODO Auto-generated method stub
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Employee employee=employeeRepository.findByEmployeeUniqueId(uniqueEmployeeId);
		if(employee==null)
		{
			System.out.println("Employee with id "+uniqueEmployeeId+ " not found");
		}
		
		employee.setEmployeeName(requestModel.getEmployeeName());
		employee.setDepartmentName(requestModel.getDepartmentName());
		employee.setSalary(requestModel.getSalary());
		
		employeeRepository.save(employee);
		return modelMapper.map(employee,Dto.class);
	}


	@Override
	public void deleteEmployee(String uniqueEmployeeId) {
		Employee employee=employeeRepository.findByEmployeeUniqueId(uniqueEmployeeId);
		if(employee==null)
		{
			System.out.println("No Such employee with id "+uniqueEmployeeId+" found");
		}
		else
		{
			System.out.println("Deletion Successful");
		}
		
		
	}
	
	
	


	
	
	

}
