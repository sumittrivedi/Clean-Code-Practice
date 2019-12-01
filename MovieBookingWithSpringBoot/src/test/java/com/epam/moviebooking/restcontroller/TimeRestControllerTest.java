package com.epam.moviebooking.restcontroller;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

class TimeRestControllerTest {
	
	String currentDate = LocalDate.now().plusDays(1).toString();
	List<String> timeList = new ArrayList<String>
	(Arrays.asList("08:00:00","10:15:00","12:00:00","16:10:00","19:15:00"));

	@Test
	void getTime() 
	{
		int i =0;
		RestAssured.baseURI = "http://localhost:8080/time";
		RequestSpecification reqspec = RestAssured.given();
		Response response= reqspec.get("?dateChoice="+currentDate+"");
		assertEquals("application/json", response.getContentType());
		assertEquals(200, response.getStatusCode());
		JsonPath jp = response.jsonPath();
		List<String> JsonData = jp.getList("time");
		for(String str : JsonData)
			assertEquals(timeList.get(i++), str);
	}

}
