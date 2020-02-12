package com.epam.moviebooking.webservices.restclient;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.epam.moviebooking.dto.AvailableSeatDto;

@Service
public class SeatAvailabilityRestClient 
{
	RestTemplate restTemplate = new RestTemplate();
	
	public AvailableSeatDto getAvailableSeat(String theatreChoice,String dateChoice,String timeChoice)
	{
		ResponseEntity<AvailableSeatDto> responseEntity = restTemplate
				.exchange("http://localhost:8080/restSeatAvailabilty?theatreChoice="+theatreChoice+"&dateChoice="+dateChoice+"&timeChoice="+timeChoice, HttpMethod.GET, null,
				new ParameterizedTypeReference<AvailableSeatDto>(){});
		return responseEntity.getBody();
	}
}
