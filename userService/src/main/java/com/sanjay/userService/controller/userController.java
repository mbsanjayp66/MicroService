package com.sanjay.userService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanjay.userService.entities.User;
import com.sanjay.userService.services.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/users")
public class userController {

	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<User>createUser(@RequestBody User user){
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(user));
	}
	
	@GetMapping("/{userId}")
	@CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod="ratingHotelFallback")
	public ResponseEntity<User>createUser(@PathVariable String userId){
		return ResponseEntity.ok(userService.getUser(userId));
	}
	
	public ResponseEntity<User>ratingHotelFallback(String userId,Exception ex){
		System.out.println("FallBack is Executed because service is down:"+ex.getMessage());
		User user = new User();
		user.setName("dummy");
		user.setEmail("dummy@gmail.com");
		user.setAbout("this user is created by dummy user");
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<User>>createUser(){
		return ResponseEntity.ok(userService.getAllUser());
	}
}
 