package com.epam.moviebooking.webservices.restclient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.epam.moviebooking.dto.SeatArrangementDto;

@Service
public class SeatArrangementRestClient {
	
RestTemplate restTemplate = new RestTemplate();
	
	public List<HashMap<SeatArrangementDto, Boolean>> seatDetails(String theatreChoice,String dateChoice,String timeChoice)
	{
		ResponseEntity<ArrayList<HashMap<SeatArrangementDto, Boolean>>> responseEntity = restTemplate
				.exchange("http://localhost:8080/restSeatArrangement?theatreChoice="+theatreChoice+"&dateChoice="+dateChoice+"&timeChoice="+timeChoice, HttpMethod.GET, null,
				new ParameterizedTypeReference<ArrayList<HashMap<SeatArrangementDto, Boolean>>>(){});
		return responseEntity.getBody();
	}

}
