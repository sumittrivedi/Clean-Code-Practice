package com.epam.moviebooking.webservices.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.epam.moviebooking.dto.TheatreDto;
import com.epam.moviebooking.service.TheatreService;

@RestController
public class TheatreRestController {
	
	@Autowired
	private TheatreService theatreService;
	
	@GetMapping(value="restTheatre", produces={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<TheatreDto>> getTheatre(@RequestParam String locationChoice, @RequestParam String movieChoice)
	{
		List<TheatreDto> theatreList = theatreService.theatreByMovie(locationChoice, movieChoice);		
		return new ResponseEntity<List<TheatreDto>>(theatreList, HttpStatus.OK);
	}
	
	@GetMapping(value="restTheatreDetails", produces={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<TheatreDto>> theatreDetails()
	{
		List<TheatreDto> theatreList = theatreService.theatreDetails();		
		return new ResponseEntity<List<TheatreDto>>(theatreList, HttpStatus.OK);
	}

}
