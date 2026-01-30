package com.crud.app.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Service;

import com.crud.app.dto.UserDetailsDto;
import com.crud.app.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	private final Map<Long, UserDetailsDto> userMap = new HashMap<>();
	
	@Override
	public String createUser(UserDetailsDto userDto) {
		
		if(userMap.containsKey(userDto.getId()))
			throw new IllegalStateException("User Already exit");
		
		userMap.put(userDto.getId(), userDto);
		return "User Created";
	}

	@Override
	public List<UserDetailsDto> getAllUser() {
		
		List<UserDetailsDto> userList = new ArrayList<>();
		
		for(Map.Entry<Long, UserDetailsDto> entry : userMap.entrySet()) {
			userList.add(entry.getValue());
		}
		
		return userList;
	}
	
	@Override
	public UserDetailsDto getUserById(Long id) {
		return userMap.get(id);
	}
	
	@Override
	public String updateUserDetails(Long id, UserDetailsDto updateUserDetails){
		
		UserDetailsDto existingUser = userMap.get(id);
		
		if(null == existingUser)
			return "User Details Not found";
		
		try {
			
			existingUser.setAddress(updateUserDetails.getAddress());
			existingUser.setAge(updateUserDetails.getAge());
			existingUser.setEmail(updateUserDetails.getEmail());
			existingUser.setName(updateUserDetails.getName());
			existingUser.setPassword(updateUserDetails.getPassword());
			
			userMap.put(id, existingUser);
			
		} catch (Exception e) {
			return e.getMessage();
		}
		
		return "User Details Updated";
	}

}











