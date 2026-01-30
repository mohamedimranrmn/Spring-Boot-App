package com.crud.app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.app.dto.UserDetailsDto;
import com.crud.app.service.UserService;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/user")
public class HomeController {
	
	@Resource
	UserService userService;

	@GetMapping("/hello")
	public String HelloWorld(){
		return "Hello People!!";
	}
	
	@PostMapping("/createUser")
	public ResponseEntity<?> createUser(@Valid @RequestBody UserDetailsDto userDto) {
		
		String response = userService.createUser(userDto);
		
		if("User Created".equalsIgnoreCase(response))
			return ResponseEntity.status(HttpStatus.CREATED).body("User Created");
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Fail to create User.");
	}
	
	@GetMapping("/getAllUser")
	public ResponseEntity<?> getAllUser(){
		
		List<UserDetailsDto> userList = userService.getAllUser();
		
		if(null == userList || userList.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("User Details Not Found...");
		}
		
		return ResponseEntity.ok().body(userList);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getUserById(@PathVariable Long id) {
		
		UserDetailsDto userDetailsDto = userService.getUserById(id);
		
		if(null == userDetailsDto) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT)
					.body("User Detail not found for the given ID : "+id);
		}
		
		return ResponseEntity.ok().body(userDetailsDto);
	}	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateUserById(@PathVariable Long id, @RequestBody UserDetailsDto updateUserDetails) {
		
		String response = userService.updateUserDetails(id, updateUserDetails);
		
		if(null == response) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT)
					.body("User Detail not Not "
							+ "updated : "+id);
		}
		
		return ResponseEntity.ok().body(response);
	}	

}








