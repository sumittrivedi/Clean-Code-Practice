package com.epam.moviebooking.webservices.restclient;

import java.time.LocalDate;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.epam.moviebooking.dto.TimeDto;

@Service
public class TimeRestClient 
{
	RestTemplate restTemplate = new RestTemplate();
	
	public List<TimeDto> getTime(LocalDate date)
	{
		ResponseEntity<List<TimeDto>> timeDtoResEntity = restTemplate
				.exchange("http://localhost:8080/restTime?dateChoice="+date, HttpMethod.GET, null, new ParameterizedTypeReference<List<TimeDto>>(){});
		return timeDtoResEntity.getBody();
	}
	
	public List<TimeDto> timeDetails()
	{
		ResponseEntity<List<TimeDto>> timeDtoResEntity = restTemplate
				.exchange("http://localhost:8080/restTimeDetails", HttpMethod.GET, null, new ParameterizedTypeReference<List<TimeDto>>(){});
		return timeDtoResEntity.getBody();
	}
}
