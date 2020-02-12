package com.epam.moviebooking.webservices.restclient;

import java.time.LocalDate;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DateRestClient 
{
	RestTemplate restTemplate = new RestTemplate();
	
	public List<LocalDate> getDate()
	{
		ResponseEntity<List<LocalDate>> resEntity = restTemplate
				.exchange("http://localhost:8080/restDate",HttpMethod.GET, null, new ParameterizedTypeReference<List<LocalDate>>(){});
		return resEntity.getBody();
	}
}
