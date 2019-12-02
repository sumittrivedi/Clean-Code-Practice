package com.epam.moviebooking.restcontroller;

import static org.junit.jupiter.api.Assertions.*;

import org.json.JSONException;
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
		jsonObj.put("locationChoice","Hyderabad");
		jsonObj.put("movieChoice","War" );
		jsonObj.put("theatreChoice","PVR Cyberabad");
		jsonObj.put("dateChoice", "2019-11-30");
		jsonObj.put("timeChoice", "8:00:00");
		jsonObj.put("premiumChoice","1" );
		jsonObj.put("executiveChoice","1" );
		jsonObj.put("ticketPrice","250" );
		jsonObj.put("cus_name","Sumit" );
		jsonObj.put("contact_no","1254125412" );
		
		 Response response = reqspec.post("/bookingDetail");
		 assertEquals(response.getStatusCode(), "201");
		assertEquals("application/json", response.getContentType());
	}

}
