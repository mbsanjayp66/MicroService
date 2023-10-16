package com.sanjay.hotelService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanjay.hotelService.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String>{

}
