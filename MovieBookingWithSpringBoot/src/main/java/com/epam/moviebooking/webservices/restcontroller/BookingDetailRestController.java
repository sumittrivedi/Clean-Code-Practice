package com.epam.moviebooking.webservices.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.epam.moviebooking.dto.AvailableSeatDto;
import com.epam.moviebooking.dto.TicketBookingDto;
import com.epam.moviebooking.service.SeatAvailabilityService;
import com.epam.moviebooking.service.ShowDetailsService;
import com.epam.moviebooking.service.TheatreService;
import com.epam.moviebooking.service.TicketBookingService;

@RestController
public class BookingDetailRestController {

	@Autowired
	private TicketBookingService ticketBookingService;
	@Autowired
	private SeatAvailabilityService seatAvailabilityService;
	@Autowired
	private TheatreService theatreService;
	@Autowired
	private ShowDetailsService showDetailsService;
	
	@PostMapping(value = "restBookingDetail")
	public TicketBookingDto saveBookingDetail(@RequestBody TicketBookingDto ticketBookingDto)
	{	
		TicketBookingDto dto = ticketBookingService.setTicketBookingDetails(ticketBookingDto);
		int theatreId = theatreService.getTheatreId(dto.getTheatreName());
		int showId = showDetailsService.getShowId(theatreId, dto.getDate(), dto.getTime());	
		AvailableSeatDto availableSeatDto = seatAvailabilityService.getAvailableSeat(showId);
		seatAvailabilityService.updateSeats(availableSeatDto, dto.getPremiumSeats(), dto.getExecutiveSeats());
		return dto;
	}
}
