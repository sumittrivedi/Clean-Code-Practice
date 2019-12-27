package com.epam.moviebooking.webservices.restclient;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.epam.moviebooking.dto.TheatreDto;

@Service
public class TheatreRestClient 
{
	RestTemplate restTemplate = new RestTemplate();
	
	public List<TheatreDto> theatreByMovie(String locationChoice, String movieChoice)
	{
		ResponseEntity<List<TheatreDto>> theatreResponseEntity = restTemplate
				.exchange("http://localhost:8080/restTheatre?locationChoice="+locationChoice+"&movieChoice="+movieChoice, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<TheatreDto>>(){});
		return theatreResponseEntity.getBody();
	}
	
	public List<TheatreDto> theatreDetails()
	{
		ResponseEntity<List<TheatreDto>> theatreResponseEntity = restTemplate
				.exchange("http://localhost:8080/restTheatreDetails", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<TheatreDto>>(){});
		
		return theatreResponseEntity.getBody();
	}
}
