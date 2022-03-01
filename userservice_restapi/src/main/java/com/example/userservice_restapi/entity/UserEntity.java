package com.example.userservice_restapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "user_table")
public class UserEntity {
	
	/*
	 * Here we have 2 id as one is used as primary key in the and other is exposed to the user.
	 */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)// this works with h2 db but not with mysql
    @Column(name = "id")
    private Integer id;
    @Column(name = "user_id",unique = true,nullable = false)
    private String userId;
    @Column(name = "first_name",nullable = false)
    private String firstName;
    @Column(name = "last_name",nullable = false)
    private String lastName;
    @Column(name = "email",nullable = false,unique = true)
    private String email;
    @Column(name = "user_encrypted_password",nullable = false)
    private String encryptedPassword;
	
    public UserEntity() {
		super();
	}

	public UserEntity(Integer id, String userId, String firstName, String lastName, String email,
			String encryptedPassword) {
		super();
		this.id = id;
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.encryptedPassword = encryptedPassword;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

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

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}
    
    
	
}