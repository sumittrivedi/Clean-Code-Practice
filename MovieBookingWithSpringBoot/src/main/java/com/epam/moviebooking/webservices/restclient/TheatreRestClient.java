package com.epam.moviebooking.webservices.restclient;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.epam.moviebooking.entity.TheatreEntity;

@Service
public class TheatreRestClient 
{
	RestTemplate restTemplate = new RestTemplate();
	
	public List<TheatreEntity> theatreByMovie(String locationChoice, String movieChoice)
	{
		ResponseEntity<List<TheatreEntity>> theatreResponseEntity = restTemplate
				.exchange("http://localhost:8080/restTheatre?locationChoice="+locationChoice+"&movieChoice="+movieChoice, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<TheatreEntity>>(){});
		return theatreResponseEntity.getBody();
	}
	
	public List<TheatreEntity> theatreDetails()
	{
		ResponseEntity<List<TheatreEntity>> theatreResponseEntity = restTemplate
				.exchange("http://localhost:8080/restTheatreDetails", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<TheatreEntity>>(){});
		
		return theatreResponseEntity.getBody();
	}
}
