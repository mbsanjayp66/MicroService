package com.sanjay.userService.external.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sanjay.userService.entities.Rating;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {
	
	
	@PostMapping("/ratings")
	public Rating updateRating(@RequestBody Rating values);

}
