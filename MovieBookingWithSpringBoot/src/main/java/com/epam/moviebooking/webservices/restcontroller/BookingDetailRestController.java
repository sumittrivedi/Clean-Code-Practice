package com.epam.moviebooking.webservices.restcontroller;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.epam.moviebooking.dto.TicketBookingDto;
import com.epam.moviebooking.service.ShowDetailsService;
import com.epam.moviebooking.service.TheatreService;
import com.epam.moviebooking.service.TicketBookingService;

@RestController
public class BookingDetailRestController {

	@Autowired
	private TicketBookingService ticketBookingService;
	@Autowired
	private TheatreService theatreService;
	@Autowired
	private ShowDetailsService showDetailsService;
	
		
	@PostMapping(value = "restBookingDetail")
	public TicketBookingDto saveBookingDetail(@RequestBody TicketBookingDto ticketBookingDto) throws NoSuchAlgorithmException
	{	
		TicketBookingDto dto = ticketBookingService.setTicketBookingDetails(ticketBookingDto);
		int theatreId = theatreService.getTheatreId(dto.getTheatreName());	
		String date = ticketBookingDto.getDate();
		String time = ticketBookingDto.getTime();
		String seatIds = ticketBookingDto.getSeatIds();
		showDetailsService.updateBookedSeats(theatreId, date, time, seatIds);
		return dto;
	}
}
