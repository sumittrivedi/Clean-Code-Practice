package com.epam.moviebooking.webservices.restclient;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class TicketPriceRestClient 
{
	RestTemplate restTemplate = new RestTemplate();
	
	public Double calculatePrice(String seatInfos)
	{
		ResponseEntity<Double> ticketPrice = restTemplate
				.exchange("http://localhost:8080/restTicketPrice?seatInfos="+seatInfos,
						HttpMethod.GET, null,new ParameterizedTypeReference<Double>(){});
		return ticketPrice.getBody();
	}
}
