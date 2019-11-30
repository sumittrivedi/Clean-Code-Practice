package com.epam.moviebooking.restcontroller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@GetMapping("seatAvailabilty")
	public AvailableSeatDto SeatAvailabilityServlet(@RequestParam String dateChoice,@RequestParam String timeChoice,HttpSession session)
	{
		session.setAttribute("dateChoice", dateChoice);
		session.setAttribute("timeChoice", timeChoice);
		String theatreChoice =  (String) session.getAttribute("theatreChoice");
		int theatreId = theatreService.getTheatreId(theatreChoice);
		int showId = showDetailsService.getShowId(theatreId, dateChoice, timeChoice);	
		AvailableSeatDto availableSeatDto = seatAvailabilityService.getAvailableSeat(showId);
		session.setAttribute("availableSeatDto", availableSeatDto);
		return availableSeatDto;
	}
}
