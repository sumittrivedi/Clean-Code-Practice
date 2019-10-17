package com.epam.movieTicketBooking.dao;

public interface TicketDao {
	
	
	public double calculatePrice(String ticketType, int noOfSeats);
	public void showTicketType();

}
