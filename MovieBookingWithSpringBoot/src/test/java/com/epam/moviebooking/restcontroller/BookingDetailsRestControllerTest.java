package com.epam.moviebooking.restcontroller;

import static org.junit.jupiter.api.Assertions.*;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

class BookingDetailsRestControllerTest {

	@Test
	void getBookingStatus() throws Exception 
	{
		RestAssured.baseURI = "http://localhost:8080";
		RequestSpecification reqspec = RestAssured.given();
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("locationName", "Kolkata");
		jsonObj.put("movieName", "Aami Bengali" );
		jsonObj.put("theatreName", "PVR Newtown");
		jsonObj.put("date", "2019-12-02");
		jsonObj.put( "time", "08:00:00");
		jsonObj.put("premiumSeats",1 );
		jsonObj.put("executiveSeats", 2 );
		jsonObj.put("price", 350.0 );
		jsonObj.put("customerName", "Sumit" );
		jsonObj.put("mobileNo", "1254125412");
		reqspec.header("Content-Type", "application/json");
		reqspec.body(jsonObj.toString());
		Response response = reqspec.post("/restBookingDetail");
		assertEquals(response.getStatusCode(), 200);
		assertEquals("application/json", response.getContentType());
	}

}
