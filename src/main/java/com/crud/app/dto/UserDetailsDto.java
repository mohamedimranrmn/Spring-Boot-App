package com.crud.app.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserDetailsDto {
	
	@NotNull(message = "Id should not be null")
	private Long id;
	
	@NotBlank(message = "name should not be null")
	private String name;
	
	@NotBlank(message = "age should not be null")
	private String age;
	
	@NotBlank(message = "address should not be null")
	private String address;
	
	@Size(min = 8, max = 16, message = "Password must be 8-16 characters")
	private String password;
	
	@Email(message = "Email is Invalid")
	private String email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
