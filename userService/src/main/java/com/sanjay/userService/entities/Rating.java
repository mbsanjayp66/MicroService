package com.sanjay.userService.entities;

public class Rating {
	private String ratingId;
	private String userId;
	private String hotelId;
	private String feedback;
	private int ratings;
	private Hotel hotel;
	public String getRatingId() {
		return ratingId;
	}
	public void setRatingId(String ratingId) {
		this.ratingId = ratingId;
	}
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getHotelId() {
		return hotelId;
	}
	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public int getRatings() {
		return ratings;
	}
	public void setRatings(int ratings) {
		this.ratings = ratings;
	}
	
	public Rating() {
		
	}
	public Rating(String ratingId, String userId, String hotelId, String feedback, int ratings) {
		this.ratingId = ratingId;
		this.userId = userId;
		this.hotelId = hotelId;
		this.feedback = feedback;
		this.ratings = ratings;
	}
	
}
