package com.sanjay.userService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sanjay.userService.Payload.ApiResponse;

@RestControllerAdvice
public class GloabalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse>handlerResourceNotFoundException(ResourceNotFoundException ex){
		ApiResponse response  = ApiResponse.builder().message(ex.getMessage()).status(HttpStatus.NOT_FOUND).success(true).build();
		return new ResponseEntity<ApiResponse>(response,HttpStatus.NOT_FOUND);
	}
}
