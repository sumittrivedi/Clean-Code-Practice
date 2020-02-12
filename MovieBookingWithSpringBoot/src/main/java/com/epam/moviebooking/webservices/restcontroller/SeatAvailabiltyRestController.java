package com.epam.moviebooking.webservices.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.epam.moviebooking.dto.AvailableSeatDto;
import com.epam.moviebooking.service.SeatAvailabilityService;
import com.epam.moviebooking.service.ShowDetailsService;
import com.epam.moviebooking.service.TheatreService;

@RestController
public class SeatAvailabiltyRestController {

	@Autowired
	private SeatAvailabilityService seatAvailabilityService;
	@Autowired
	private TheatreService theatreService;
	@Autowired
	private ShowDetailsService showDetailsService;
	
	@GetMapping(value = "restSeatAvailabilty", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<AvailableSeatDto> getAvailabileSeats(@RequestParam String theatreChoice,@RequestParam String dateChoice,@RequestParam String timeChoice)
	{
		int theatreId = theatreService.getTheatreId(theatreChoice);
		int showId = showDetailsService.getShowId(theatreId, dateChoice, timeChoice);	
		AvailableSeatDto availableSeatDto = seatAvailabilityService.getAvailableSeat(showId);
		return new ResponseEntity<AvailableSeatDto>(availableSeatDto, HttpStatus.OK);
	}
}
