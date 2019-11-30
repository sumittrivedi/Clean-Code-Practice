package com.epam.moviebooking.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.moviebooking.dto.LocationDto;
import com.epam.moviebooking.service.LocationService;

@RestController
public class LocationRestController {
	
	@Autowired
	private LocationService locationservice;
	
	@GetMapping(value = "location" , produces={MediaType.APPLICATION_JSON_VALUE})
	public List<LocationDto> locationServlet()
	{
		List<LocationDto> locationList = locationservice.getLocation();
		return locationList;
	}
}
