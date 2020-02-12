package com.epam.moviebooking.webservices.restclient;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.epam.moviebooking.entity.LocationEntity;

@Service
public class LocationRestclient {

	RestTemplate restTemplate = new RestTemplate();

	public List<LocationEntity> getLocation() 
	{
		ResponseEntity<List<LocationEntity>> locationResponseEntity = restTemplate
				.exchange("http://localhost:8080/restLocation", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<LocationEntity>>(){});
		return locationResponseEntity.getBody();
	}
	
}
