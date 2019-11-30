package com.epam.moviebooking.service;

import org.springframework.stereotype.Service;

@Service
public class TicketPriceService {
	
	public double calculatePrice(int premiumSeatChoice,int executiveSeatChoice)
	{
		return 150*premiumSeatChoice + 100*executiveSeatChoice ;
	}

}
