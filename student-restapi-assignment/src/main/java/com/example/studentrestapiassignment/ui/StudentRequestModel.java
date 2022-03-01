package com.example.studentrestapiassignment.ui;

import java.util.Set;

public class StudentRequestModel {
	
	//private int id;
	private String firstName;
	private String lastName;
	private String email;
	private Set<String> images;
	public StudentRequestModel() {
		super();
	}
	
	public StudentRequestModel( String firstName, String lastName, String email, Set<String> images) {
		super();
		//this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.images = images;
	}
	
//	public int getId() {
//		return id;
//	}
//	
//	public void setId(int id) {
//		this.id = id;
//	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Set<String> getImages() {
		return images;
	}
	
	public void setImages(Set<String> images) {
		this.images = images;
	}
	

}
