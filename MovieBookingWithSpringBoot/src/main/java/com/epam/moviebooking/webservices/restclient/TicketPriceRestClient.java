package com.epam.moviebooking.webservices.restclient;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.epam.moviebooking.dto.SeatInfoDto;
import com.epam.moviebooking.dto.TicketBookingDto;

@Service
public class TicketPriceRestClient 
{
	RestTemplate restTemplate = new RestTemplate();
	
	public Double calculatePrice(List<SeatInfoDto> seatInfos)
	{
//		ResponseEntity<Double> ticketPrice = restTemplate
//				.exchange("http://localhost:8080//,
//						HttpMethod.POST, null,new ParameterizedTypeReference<Double>(){});
//		return ticketPrice.getBody();
		System.out.println(restTemplate.postForEntity("http://localhost:8080/restTicketPrice", seatInfos, SeatInfoDto.class).getBody());
		return restTemplate.postForEntity("http://localhost:8080/restTicketPrice", seatInfos, Double.class).getBody();

	}
}
