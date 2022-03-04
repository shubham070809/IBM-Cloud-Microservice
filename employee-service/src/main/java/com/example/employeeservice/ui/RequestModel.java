package com.example.employeeservice.ui;

public class RequestModel {
	
private String employeeName;
    
    private String departmentName;
    
    private Double salary;

	public RequestModel() {
		super();
	}

	public RequestModel(String employeeName, String departmentName, Double salary) {
		super();
		this.employeeName = employeeName;
		this.departmentName = departmentName;
		this.salary = salary;
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
