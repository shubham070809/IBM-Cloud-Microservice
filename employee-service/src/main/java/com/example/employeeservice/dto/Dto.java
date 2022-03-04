package com.example.employeeservice.dto;

public class Dto {

	private String employeeUniqueId;
    
    private String employeeName;
    
    private String departmentName;
    
    private Double salary;

	public Dto() {
		super();
	}

	public Dto(String employeeUniqueId, String employeeName, String departmentName, Double salary) {
		super();
		this.employeeUniqueId = employeeUniqueId;
		this.employeeName = employeeName;
		this.departmentName = departmentName;
		this.salary = salary;
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
