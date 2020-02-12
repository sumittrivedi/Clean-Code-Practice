package com.epam.moviebooking.webservices.restclient;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.epam.moviebooking.entity.MovieEntity;

@Service
public class MovieRestClient 
{
	RestTemplate restTemplate = new RestTemplate();
	
	public List<MovieEntity> movieByLocation(String locationChoice)
	{
		ResponseEntity<List<MovieEntity>> locationResponseEntity = restTemplate
				.exchange("http://localhost:8080/restMovie?locationChoice="+locationChoice, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<MovieEntity>>(){});
		return locationResponseEntity.getBody();
	}
	
	public List<MovieEntity> movieDetails()
	{
		ResponseEntity<List<MovieEntity>> locationResponseEntity = restTemplate
				.exchange("http://localhost:8080/restMovieDetails", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<MovieEntity>>(){});
		return locationResponseEntity.getBody();
	}
}
