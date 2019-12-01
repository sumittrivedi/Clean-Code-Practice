package com.epam.moviebooking.restcontroller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

class BookingDetailsRestControllerTest {

	@Test
	void getBookingStatus() 
	{
//		int i =0;
		RestAssured.baseURI = "http://localhost:8080/bookingDetail";
		RequestSpecification reqspec = RestAssured.given();
		Response response= reqspec.post();
//		JsonPath jp = response.jsonPath();
//		String movieName = jp.getString("movieName");
		
		
//		assertEquals(200, response.getStatusCode());
		assertEquals("application/json", response.getContentType());
	}

}
