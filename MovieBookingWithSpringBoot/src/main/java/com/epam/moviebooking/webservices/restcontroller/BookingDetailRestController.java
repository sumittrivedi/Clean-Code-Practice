package com.epam.moviebooking.webservices.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.epam.moviebooking.entity.TicketBookingEntity;
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
	public TicketBookingEntity saveBookingDetail(@RequestBody TicketBookingEntity ticketBookingEntity)
	{	
		TicketBookingEntity entity = ticketBookingService.setTicketBookingDetails(ticketBookingEntity);
		int theatreId = theatreService.getTheatreId(entity.getTheatreName());	
		String date = ticketBookingEntity.getDate();
		String time = ticketBookingEntity.getTime();
		String seatIds = ticketBookingEntity.getSeatIds();
		showDetailsService.updateBookedSeats(theatreId, date, time, seatIds);
		return entity;
	}
}
