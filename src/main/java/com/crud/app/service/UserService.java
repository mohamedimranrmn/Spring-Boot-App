package com.crud.app.service;

import java.util.List;

import com.crud.app.dto.UserDetailsDto;


public interface UserService {

	String createUser(UserDetailsDto userDto);

	List<UserDetailsDto> getAllUser();

	UserDetailsDto getUserById(Long id);
	
	String updateUserDetails(Long id, UserDetailsDto updateUserDetails);

}
