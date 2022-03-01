package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
 
	@GetMapping("/displayEmployees")
	public String listEmployees(Model theModel) {
//		 // create employees
//		 Employee emp1 = new Employee(1, "Leslie", "Andrews", "leslie@luv2code.com");
//		 Employee emp2 = new Employee(2, "Emma", "Baumgarten", "emma@luv2code.com");
//		 Employee emp3 = new Employee(3, "Avani", "Gupta", "avani@luv2code.com");
//		 // create the list
//		 List<Employee> theEmployees = new ArrayList<>();
//		 // add to the list
//		 theEmployees.add(emp1);
//		 theEmployees.add(emp2);
//		 theEmployees.add(emp3);
//		 // add to the spring model
//		 theModel.addAttribute("employees", theEmployees);
//		 return "displayEmployees";
		
		// get customers from the service
		List<Employee> theCustomers = employeeService.getAllEmployee();

		// add the customers to the model
		theModel.addAttribute("employees", theCustomers);

		return "displayEmployees";

 }
	
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
	 // create model attribute to bind form data
	 Employee employee = new Employee();
	 theModel.addAttribute("employee", employee);
	 return "showFormForAdd";
	 }
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
	 // save the employee
	 employeeService.createEmployee(employee);
	 // use a redirect to prevent duplicate submissions
	 return "redirect:/employees/displayEmployees";
	 }
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId,Model theModel) {
		 // get the employee from the service
		 Employee theEmployee = employeeService.getEmployee(theId);
		 // set employee as a model attribute to pre-populate the form
		 theModel.addAttribute("employee", theEmployee);
		 // send over to our form
		 return "showFormForAdd";
	 }
	
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int theId) {
	 // delete the employee
	 employeeService.deleteEmployee(theId);
	 // redirect to /employees/list
	 return "redirect:/employees/displayEmployees";
	 }
}