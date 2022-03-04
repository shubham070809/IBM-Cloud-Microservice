package com.example.employeeservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employees")
public class Employee {
    @Id
    private Integer employeeId;
    
    private String employeeUniqueId;
    
    private String employeeName;
    
    private String departmentName;
    
    private Double salary;

	public Employee() {
		super();
	}

	public Employee(Integer employeeId, String employeeUniqueId, String employeeName, String departmentName,
			Double salary) {
		super();
		this.employeeId = employeeId;
		this.employeeUniqueId = employeeUniqueId;
		this.employeeName = employeeName;
		this.departmentName = departmentName;
		this.salary = salary;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeUniqueId() {
		return employeeUniqueId;
	}

	public void setEmployeeUniqueId(String employeeUniqueId) {
		this.employeeUniqueId = employeeUniqueId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

    
}