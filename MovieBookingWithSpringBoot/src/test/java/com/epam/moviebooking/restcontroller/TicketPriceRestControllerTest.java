package com.epam.moviebooking.restcontroller;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.epam.moviebooking.service.TicketPriceService;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

class TicketPriceRestControllerTest {
	

	@Mock 
	private HttpSession session;
	@Mock
	private TicketPriceService ticketPriceService;
	
	@BeforeEach
	void init()
	{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	void ticketPrice()
	{
		RestAssured.baseURI = "http://localhost:8080/restTicketPrice";
		RequestSpecification reqspec = RestAssured.given();
		Response response= reqspec.get("?seatInfos=A5+200.0");
		when(ticketPriceService.calculatePrice("A5 200")).thenReturn(200.0);
		assertEquals(200, response.getStatusCode());
		assertEquals(200.0,ticketPriceService.calculatePrice("A5 200"));
	}

}
