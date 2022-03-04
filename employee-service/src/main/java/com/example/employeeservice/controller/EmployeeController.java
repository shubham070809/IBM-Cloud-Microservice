package com.example.employeeservice.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeeservice.dto.Dto;
import com.example.employeeservice.model.Employee;
import com.example.employeeservice.service.EmployeeService;
import com.example.employeeservice.ui.RequestModel;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
public class EmployeeController {
	
	private final EmployeeService employeeService;
	private final ModelMapper modelMapper;


	@Autowired
	public EmployeeController(EmployeeService employeeService, ModelMapper modelMapper) {
		super();
		this.employeeService = employeeService;
		this.modelMapper = modelMapper;

	}
	
	
	/*Notes
	 * 1. The annotation used below is possible due to the open api documentation
	 * 2. The @Operation is used to provide additonal comments in the api
	 * 3. @Api response is used to generate the reponse code and description when that particular endpoint is
	 * hit succesfully*/
	@Operation(summary = "employee api create new employee")
    @ApiResponse(responseCode = "201",description = "created sucesfully")
	@PostMapping("/employees")
	public ResponseEntity<Dto> createEmployee(@RequestBody RequestModel requestModel)
	{
		Employee employee=modelMapper.map(requestModel,Employee.class);
		Dto dto=employeeService.createEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
	}
	
	@Operation(summary = "employee api get all employee")
    @ApiResponse(responseCode = "200",description = "sucesfully fetched")
	@GetMapping("/employees")
	public ResponseEntity<List<Dto>> getAllEmployees()
	{
		List<Dto> list=employeeService.getAllEmployees();
		return ResponseEntity.ok(list);
	}
	
	@Operation(summary = "employee api get employee by id")
    @ApiResponse(responseCode = "200",description = "sucesfully fetched")
	@GetMapping("/employeeById/{uniqueEmployeeId}")
	public ResponseEntity<Dto> getByUniqueEmployeeId(@PathVariable("uniqueEmployeeId") String uniqueEmployeeId)
	{
		Dto dto=employeeService.getByEmployeeUniqueId(uniqueEmployeeId);
		return ResponseEntity.ok(dto);
	}
	
	@Operation(summary = "employee api update employee")
    @ApiResponse(responseCode = "200",description = "sucesfully updated")
	@PutMapping("/employeesUpdate/{uniqueEmployeeId}")
	public ResponseEntity<Dto> updateByUniqueEmployeeId(@RequestBody RequestModel requestModel,@PathVariable("uniqueEmployeeId") String uniqueEmployeeId)
	{
		Dto dto=employeeService.updateEmployee(requestModel,uniqueEmployeeId);
		return ResponseEntity.ok(dto);
	}
	
	@Operation(summary = "employee api delete employee")
    @ApiResponse(responseCode = "200",description = "sucesfully deleted")
	@DeleteMapping("/employeesDelete/{uniqueEmployeeId}")
	public String deleteEmployee(@PathVariable("uniqueEmployeeId") String uniqueEmployeeId)
	{
		employeeService.deleteEmployee(uniqueEmployeeId);
		return "deletion Successful";
	}
	

}
