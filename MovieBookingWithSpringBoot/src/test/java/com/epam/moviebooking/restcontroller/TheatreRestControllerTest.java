package com.epam.moviebooking.restcontroller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@SpringBootTest
class TheatreRestControllerTest {

	ArrayList<String> warTheatre = new ArrayList<String>(Arrays.asList("PVR Cyberabad","INOX Hitech City"));

	
	@Test
	void getTheatre() 
	{
		int i =0;
		RestAssured.baseURI = "http://localhost:8080/theatre";
		RequestSpecification reqspec = RestAssured.given();
		Response response= reqspec.get("?movieChoice=War");
		JsonPath jp = response.jsonPath();
		List<String> theatreList = jp.getList("theatreName");
		for(String str : theatreList)
			assertEquals(warTheatre.get(i++), str);
		String content = response.getContentType();
		int status = response.getStatusCode();
		assertEquals("application/json", content);
		assertEquals(200, status);

	}

}
