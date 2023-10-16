package com.sanjay.userService.impl;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.sanjay.userService.entities.Hotel;
import com.sanjay.userService.entities.Rating;
import com.sanjay.userService.entities.User;
import com.sanjay.userService.external.service.HotelService;
import com.sanjay.userService.repositories.UserRepository;
import com.sanjay.userService.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@Autowired
	private HotelService hotelService;
	

	@Override
	public User saveUser(User user) {
		
		String userId = UUID.randomUUID().toString();
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public User getUser(String userId) {
		User user = userRepository.findById(userId).orElseThrow(()->new ResourceAccessException("User with given id %s not found: "+ userId));
		//http://localhost:8000/ratings/users/b1283b94-35e2-4bde-bf48-c8e0dfd67897
		
		Rating[] ratings = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+userId, Rating[].class);
		List<Rating>ratingsList=Arrays.stream(ratings).map(rating->{
			//ResponseEntity<Hotel> hotel = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
			Hotel hotel = hotelService.getHotel(rating.getHotelId());
			rating.setHotel(hotel);
			return rating;
		}).collect(Collectors.toList());
		user.setRatings(ratingsList);
		System.out.println("Data:"+ratingsList);
		return user;
	}

}
