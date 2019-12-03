package com.epam.moviebooking.webservices.restclient;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.epam.moviebooking.dto.AvailableSeatDto;

@Service
public class SeatAvailabilityRestClient 
{
	RestTemplate restTemplate = new RestTemplate();
	
	public AvailableSeatDto getAvailableSeat(int showId)
	{
		return ;
	}
}
