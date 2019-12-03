package com.epam.moviebooking.service;

import org.springframework.stereotype.Service;

@Service
public class TicketPriceService {
	
	private final double premiumSeatPrice = 150.00;
	private final double executiveSeatPrice = 100.00;
	
	public double calculatePrice(int premiumSeatChoice,int executiveSeatChoice)
	{
		return premiumSeatPrice*premiumSeatChoice + executiveSeatPrice*executiveSeatChoice ;
	}

}
