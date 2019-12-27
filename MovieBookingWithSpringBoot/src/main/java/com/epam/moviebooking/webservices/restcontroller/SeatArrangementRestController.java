package com.epam.moviebooking.webservices.restcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.SortedMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.epam.moviebooking.dto.SeatInfoDto;
import com.epam.moviebooking.service.SeatArrangementService;
import com.epam.moviebooking.service.TheatreService;

@RestController
public class SeatArrangementRestController {

	@Autowired
	SeatArrangementService seatArrangementService;
	@Autowired
	TheatreService theatreService;
	
	@GetMapping(value = "restSeatArrangement", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<SortedMap<SeatInfoDto, Boolean>> seatArrangement(@RequestParam String theatreChoice,@RequestParam String dateChoice,@RequestParam String timeChoice)
	{
		int theatreId = theatreService.getTheatreId(theatreChoice);
		SortedMap<SeatInfoDto, Boolean> seatDetails = seatArrangementService.getSeatDetails(theatreId, dateChoice, timeChoice);
		return new ResponseEntity<SortedMap<SeatInfoDto,Boolean>>(seatDetails, HttpStatus.OK);
	}
	
	
}
