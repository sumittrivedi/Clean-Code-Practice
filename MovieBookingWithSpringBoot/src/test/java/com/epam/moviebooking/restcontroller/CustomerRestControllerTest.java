package com.epam.moviebooking.restcontroller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@SpringBootTest
class CustomerRestControllerTest {

	@Test
	void addCustomerDeatils() 
	{
		RestAssured.baseURI = "localhost:8080/customer";
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.put("");
		Response response = reqSpec.post();
		JsonPath jp = response.jsonPath();
		String str = jp.getString("");
		assertEquals("Customer details entered", str);
		
		
	}

}
