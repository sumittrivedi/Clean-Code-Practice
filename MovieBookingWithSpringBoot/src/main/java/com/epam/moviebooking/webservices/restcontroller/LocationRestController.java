package com.epam.moviebooking.webservices.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.moviebooking.dto.LocationDto;
import com.epam.moviebooking.service.LocationService;

@RestController
public class LocationRestController {
	
	@Autowired
	private LocationService locationservice;
	
	@GetMapping(value = "restLocation" , produces={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<LocationDto>> getLocation()
	{
		List<LocationDto> locationList = locationservice.getLocation();
		return new ResponseEntity<List<LocationDto>>(locationList, HttpStatus.OK);
	}
}
