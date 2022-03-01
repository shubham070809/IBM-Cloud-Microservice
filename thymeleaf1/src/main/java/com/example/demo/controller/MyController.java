package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
	
	@GetMapping("/")
	public String sayHello(Model theModel) {

	 theModel.addAttribute("theDate", new java.util.Date());

	 return "helloworld";
	 } 

	@GetMapping("/usingInternalCss")
	public String internalCss(Model theModel) {

	 theModel.addAttribute("theDate", new java.util.Date());

	 return "internalCss";
	 } 

}
