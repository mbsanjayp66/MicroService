package com.sanjay.hotelService.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import com.sanjay.hotelService.entities.Hotel;
import com.sanjay.hotelService.repositories.HotelRepository;
import com.sanjay.hotelService.services.HotelServices;

@Service
public class HotelServiceImpl implements HotelServices{

	@Autowired
	private HotelRepository hotelRepository;
	@Override
	public Hotel create(Hotel h) {
		 String id = UUID.randomUUID().toString();
		 h.setId(id);
		return hotelRepository.save(h);
	}

	@Override
	public List<Hotel> getAll() {
		return hotelRepository.findAll();
	}

	@Override
	public Hotel get(String id) {
		return hotelRepository.findById(id).orElseThrow(()->new ResourceAccessException("Hotel Not found for the given id"));
	}

}
