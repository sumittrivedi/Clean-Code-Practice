package com.epam.moviebooking.webservices.restclient;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.epam.moviebooking.entity.TicketBookingEntity;

@Service
public class BookingDetailRestClient 
{
	RestTemplate restTemplate = new RestTemplate();
	
	public TicketBookingEntity setTicketBookingDetails(TicketBookingEntity ticketBookingDto)
	{
		return restTemplate.postForEntity("http://localhost:8080/restBookingDetail", ticketBookingDto, TicketBookingEntity.class).getBody();

	}

}
