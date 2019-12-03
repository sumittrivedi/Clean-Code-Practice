package com.epam.moviebooking.webservices.restclient;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.epam.moviebooking.dto.TicketBookingDto;

@Service
public class BookingDetailRestClient 
{
	RestTemplate restTemplate = new RestTemplate();
	
	public void setTicketBookingDetails(TicketBookingDto ticketBookingDto)
	{
		
	}

}
