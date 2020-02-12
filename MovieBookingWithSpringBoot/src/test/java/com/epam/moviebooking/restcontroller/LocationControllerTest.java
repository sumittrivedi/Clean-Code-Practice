package com.epam.moviebooking.restcontroller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.epam.moviebooking.entity.LocationEntity;
import com.epam.moviebooking.service.LocationService;
import com.epam.moviebooking.webservices.restcontroller.LocationRestController;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.*;

@SpringBootTest
class LocationControllerTest {
	
	@Mock
	private LocationService locationService;	
	@InjectMocks
	private LocationRestController locationRestController;
	void init() {
		MockitoAnnotations.initMocks(this);
	}

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
	
@Test
void getLocationUnitTesing() {
	
	List<LocationEntity> locationEntities = new ArrayList<>();
	LocationEntity entity = new LocationEntity();
	entity.setLocationId(1);
	entity.setLocationName("Hyderabad");
	locationEntities.add(entity);	
	ResponseEntity<List<LocationEntity>> responseEntity = locationRestController.getLocation();
	when(locationService.getLocation()).thenReturn(locationEntities);
	assertEquals(responseEntity, locationRestController.getLocation());
		
	}

@Test
void addLocationUnitTesing() {
	
	String locationName;
	ResponseEntity<String> responseEntity = locationRestController.addLocation(locationName);
	when(locationService.addLocation(locationName));
	assertEquals(responseEntity, locationRestController.getLocation());
		
	}


}
