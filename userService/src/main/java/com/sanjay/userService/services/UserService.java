package com.sanjay.userService.services;

import java.util.List;

import com.sanjay.userService.entities.User;

public interface UserService {
	
	User saveUser(User user);
	
	List<User>getAllUser();
	
	User getUser(String userId);
}
