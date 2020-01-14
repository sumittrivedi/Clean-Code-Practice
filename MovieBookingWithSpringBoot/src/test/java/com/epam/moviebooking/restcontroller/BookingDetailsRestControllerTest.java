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
		jsonObj.put( "seatIds", "A1 B2");
		jsonObj.put( "totalticketPrice", 400.0);
		jsonObj.put("customerName", "Sumit" );
		jsonObj.put("mobileNo", "9998585452");
		reqspec.header("Content-Type", "application/json");
		reqspec.body(jsonObj.toString());
		Response response = reqspec.post("/restBookingDetail");
		assertEquals(200,response.getStatusCode());
		assertEquals("application/json", response.getContentType());
	}

}
