package com.epam.moviebooking.restcontroller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

class SeatAvailabilityRestControllerTest {

	@Test
	void getseatAvailability()
	{
		RestAssured.baseURI = "http://localhost:8080/seatAvailabilty";
		RequestSpecification reqspec = RestAssured.given();
		Response response= reqspec.get("?theatreChoice=PVR Cyberabad&dateChoice=2019-12-01&timeChoice=08:00:00");
		assertEquals("application/json", response.getContentType());
		assertEquals(200, response.getStatusCode());
		JsonPath jp = response.jsonPath();
		String JsonPremiumSeats = jp.get("premiumAvailability");
		String JsonExecutiveSeats = jp.get("executiveAvailabilty");
		assertEquals(17, JsonPremiumSeats);
		assertEquals(77, JsonExecutiveSeats);
	}

}
