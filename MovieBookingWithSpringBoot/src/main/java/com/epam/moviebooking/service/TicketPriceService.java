package com.epam.moviebooking.service;


import org.springframework.stereotype.Service;

@Service
public class TicketPriceService {
	
	public double calculatePrice(String seatInfos)
	{
		Double totalticketPrice = 0.00;
		String[] selectedSeats = seatInfos.split(",");
		for (String str : selectedSeats) 
		{
			String[] subStrings = str.split(" ");
			totalticketPrice += Double.parseDouble(subStrings[1]);
		}
		return totalticketPrice;
	}

}
