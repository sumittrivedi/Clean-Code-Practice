package com.epam.moviebooking.webservices.restclient;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.epam.moviebooking.dto.AvailableSeatDto;

@Service
public class TicketPriceRestClient 
{
	RestTemplate restTemplate = new RestTemplate();
	
	public AvailableSeatDto calculatePrice(int premiumSeatChoice,int executiveSeatChoice,AvailableSeatDto availableSeatDto)
	{
		return restTemplate.postForEntity("http://localhost:8080/restTicketPrice/"+premiumSeatChoice+"/"+executiveSeatChoice, availableSeatDto, AvailableSeatDto.class).getBody();
	}
}
