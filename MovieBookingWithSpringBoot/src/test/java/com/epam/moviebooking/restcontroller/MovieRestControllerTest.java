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
class MovieRestControllerTest {

	ArrayList<String> HydMovieList = new ArrayList<String>(Arrays.asList("War","Joker","Dream Girl","Mangalyaan"));

	@Test
	void getMovieOfHyderabad()
	{
		int i =0;
		RestAssured.baseURI = "http://localhost:8080/restMovie";
		RequestSpecification reqspec = RestAssured.given();
		Response response= reqspec.get("?locationChoice=Hyderabad");
		JsonPath jp = response.jsonPath();
		List<String> movieList = jp.getList("movieName");
		for(String str : movieList)
			assertEquals(HydMovieList.get(i++), str);
		String content = response.getContentType();
		int status = response.getStatusCode();
		assertEquals("application/json", content);
		assertEquals(200, status);
	}

}
