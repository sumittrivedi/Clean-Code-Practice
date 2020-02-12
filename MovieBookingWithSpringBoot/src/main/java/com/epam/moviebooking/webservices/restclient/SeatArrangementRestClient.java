package com.epam.moviebooking.webservices.restclient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.epam.moviebooking.entity.SeatArrangementEntity;

@Service
public class SeatArrangementRestClient {
	
RestTemplate restTemplate = new RestTemplate();
	
	public List<HashMap<SeatArrangementEntity, Boolean>> seatDetails(String theatreChoice,String dateChoice,String timeChoice)
	{
		ResponseEntity<ArrayList<HashMap<SeatArrangementEntity, Boolean>>> responseEntity = restTemplate
				.exchange("http://localhost:8080/restSeatArrangement?theatreChoice="+theatreChoice+"&dateChoice="+dateChoice+"&timeChoice="+timeChoice, HttpMethod.GET, null,
				new ParameterizedTypeReference<ArrayList<HashMap<SeatArrangementEntity, Boolean>>>(){});
		return responseEntity.getBody();
	}

}
