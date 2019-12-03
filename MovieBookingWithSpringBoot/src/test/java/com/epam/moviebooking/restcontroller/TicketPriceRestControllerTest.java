package com.epam.moviebooking.restcontroller;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.epam.moviebooking.dto.AvailableSeatDto;
import com.epam.moviebooking.service.SeatAvailabilityService;
import com.epam.moviebooking.service.TicketPriceService;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

class TicketPriceRestControllerTest {
	
//	@Mock
//	private AvailableSeatDto availableSeatDto;
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
	
//	@Mock
//	Ticket

	@Test
	void ticketPrice()
	{
		
		AvailableSeatDto availableSeatDto = new AvailableSeatDto();
		availableSeatDto.setExecutiveAvailabilty(10);
		availableSeatDto.setPremiumAvailability(4);
		availableSeatDto.setShowId(185);
		RestAssured.baseURI = "http://localhost:8080/ticketPrice";
		RequestSpecification reqspec = RestAssured.given();
		Response response= reqspec.get("?premiumSeatChoice=1&executiveSeatChoice=2");
		//when(session.getAttribute("availableSeatDto")).thenReturn(availableSeatDto);
		when(ticketPriceService.calculatePrice(1,2)).thenReturn(350.00);
		JsonPath jp = response.jsonPath();
		
		String content = response.getContentType();
		int status = response.getStatusCode();
		
		assertEquals("application/json", content);
		assertEquals(200, status);

	}

}
