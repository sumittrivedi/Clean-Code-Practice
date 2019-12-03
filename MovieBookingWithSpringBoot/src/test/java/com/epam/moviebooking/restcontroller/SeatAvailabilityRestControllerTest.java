package com.epam.moviebooking.restcontroller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpRequest;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

class SeatAvailabilityRestControllerTest {
	
	@Mock
	private HttpServletRequest request;

	void init() {
		MockitoAnnotations.initMocks(this);
	}
	
//	@MockBean
//	MockHttpSession session;
//	
//	@Autowired
//	MockMvc mock;

	@Test
	void getseatAvailability() {
		
		RestAssured.baseURI = "http://localhost:8080/seatAvailabilty";
		RequestSpecification reqspec = RestAssured.given();
		request.setAttribute("theatreChoice", "theatreChoice");
		HttpSession session = request.getSession();
		session.setAttribute("theatreChoice", "theatreChoice");
		when(session.getAttribute("theatreChoice")).thenReturn("PVR Cyberabad");

		Response response = reqspec.get("?dateChoice="+LocalDate.now().toString()+"&timeChoice=08:00:00");
		assertEquals("application/json", response.getContentType());
		assertEquals(200, response.getStatusCode());
//		JsonPath jp = response.jsonPath();
//		String JsonPremiumSeats = jp.get("premiumAvailability");
//		String JsonExecutiveSeats = jp.get("executiveAvailabilty");
//		assertEquals(17, JsonPremiumSeats);
//		assertEquals(77, JsonExecutiveSeats);
	}

}
