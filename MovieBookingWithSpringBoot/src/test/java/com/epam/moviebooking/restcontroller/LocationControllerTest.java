package com.epam.moviebooking.restcontroller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.*;

@SpringBootTest
class LocationControllerTest {
	
	List<String> locationList = new ArrayList<String>
	(Arrays.asList("Hyderabad","Kolkata","Chennai","Patna","Delhi","Pune","Banglore"));

	@Test
	void getLocation() {
		
		int i =0;
		RestAssured.baseURI = "http://localhost:8080/restLocation";
		RequestSpecification reqspec = RestAssured.given();
		Response response= reqspec.get();
		assertEquals(200, response.getStatusCode());
		assertEquals("application/json", response.getContentType());
		JsonPath jp = response.jsonPath();
		List<String> JsonLocation = jp.getList("locationName");
		for(String str : JsonLocation)
			assertEquals(locationList.get(i++), str);
	}

}
