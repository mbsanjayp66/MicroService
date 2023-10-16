package com.sanjay.hotelService.services;

import java.util.List;

import com.sanjay.hotelService.entities.Hotel;

public interface HotelServices {
	
	
	Hotel create(Hotel h);
	
	List<Hotel> getAll();
	
	Hotel get(String id);
}
