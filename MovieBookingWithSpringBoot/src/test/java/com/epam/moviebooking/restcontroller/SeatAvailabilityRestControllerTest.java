package com.epam.moviebooking.restcontroller;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

class SeatAvailabilityRestControllerTest {
	
	@Test
	void getseatAvailability() {
		
		RestAssured.baseURI = "http://localhost:8080/restSeatAvailabilty";
		RequestSpecification reqspec = RestAssured.given();
		Response response = reqspec.get("?theatreChoice=PVR Cyberabad&dateChoice=2019-12-03&timeChoice=08:00:00");
		assertEquals(200, response.getStatusCode());
		assertEquals("application/json", response.getContentType());
		JsonPath jp = response.jsonPath();
		Integer JsonPremiumSeats = jp.get("premiumAvailability");
		Integer JsonExecutiveSeats = jp.get("executiveAvailabilty");
		assertEquals(12, JsonPremiumSeats);
		assertEquals(64, JsonExecutiveSeats);
	}

}
