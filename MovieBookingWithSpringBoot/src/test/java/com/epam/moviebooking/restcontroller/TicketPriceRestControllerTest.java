package com.epam.moviebooking.restcontroller;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.epam.moviebooking.dto.AvailableSeatDto;
import com.epam.moviebooking.service.SeatAvailabilityService;
import com.epam.moviebooking.service.TicketPriceService;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

class TicketPriceRestControllerTest {
	

	@Mock 
	private HttpSession session;
	@Mock 
	private SeatAvailabilityService seatAvailabilityService;
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
		AvailableSeatDto availableSeatDto = new AvailableSeatDto();
		availableSeatDto.setPremiumAvailability(20);
		availableSeatDto.setExecutiveAvailabilty(80);
		availableSeatDto.setShowId(230);
		RestAssured.baseURI = "http://localhost:8080/restTicketPrice";
		RequestSpecification reqspec = RestAssured.given();
		Response response= reqspec.get("/1/5");
		assertEquals(200, response.getStatusCode());
		when(ticketPriceService.calculatePrice(1,2)).thenReturn(650.00);
		assertEquals("application/json", response.getContentType());
		
	}

}
