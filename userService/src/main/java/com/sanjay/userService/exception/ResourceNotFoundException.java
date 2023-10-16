package com.sanjay.userService.exception;

public class ResourceNotFoundException extends RuntimeException{
	
	public ResourceNotFoundException() {
		super("Resource Not found on Server");
	}
	
	public ResourceNotFoundException(String msg) {
		super(msg);
	}
}
