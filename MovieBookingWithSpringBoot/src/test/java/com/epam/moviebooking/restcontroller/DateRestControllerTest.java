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

class DateRestControllerTest {
	
	LocalDate currentDate = LocalDate.now();
	List<String> dateList = new ArrayList<String>
	(Arrays.asList(currentDate.toString(),currentDate.plusDays(1).toString(),currentDate.plusDays(2).toString()));

	@Test
	void getDate() {
		
		int i =0;
		RestAssured.baseURI = "http://localhost:8080/restDate";
		RequestSpecification reqspec = RestAssured.given();
		Response response= reqspec.get();
		assertEquals("application/json", response.getContentType());
		assertEquals(200, response.getStatusCode());
		JsonPath jp = response.jsonPath();
		List<String> JsonData = jp.getList("");
		for(String str : JsonData)
			assertEquals(dateList.get(i++), str);
	}

}
