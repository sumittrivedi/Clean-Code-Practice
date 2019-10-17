package com.epam.movieTicketBooking.dto;

public class TicketDto {
	
	String ticketType;
	double ticketPrice;
	
	public TicketDto(String ticketType, double ticketPrice) {
		this.ticketType = ticketType;
		this.ticketPrice = ticketPrice;
	}

	public String getTicketType() {
		return ticketType;
	}
	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}
	public double getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	
}
