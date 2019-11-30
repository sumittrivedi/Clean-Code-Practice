package com.epam.moviebooking.restcontroller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.epam.moviebooking.dto.AvailableSeatDto;
import com.epam.moviebooking.service.SeatAvailabilityService;
import com.epam.moviebooking.service.TicketPriceService;

@RestController
public class TicketPriceRestController {
	
	@Autowired
	private TicketPriceService ticketPriceService;
	@Autowired
	private SeatAvailabilityService seatAvailabilityService;
	
	@GetMapping(value = "ticketPrice")
	public Double TicketPriceServlet(@RequestParam int premiumSeatChoice ,@RequestParam int executiveSeatChoice ,HttpSession session)
	{
		session.setAttribute("premiumSeatChoice", premiumSeatChoice);
		session.setAttribute("executiveSeatChoice", executiveSeatChoice);
		AvailableSeatDto availableSeatDto = (AvailableSeatDto) session.getAttribute("availableSeatDto");
		seatAvailabilityService.updateSeats(availableSeatDto,premiumSeatChoice,executiveSeatChoice);
		Double ticketPrice = ticketPriceService.calculatePrice(premiumSeatChoice,executiveSeatChoice);
		session.setAttribute("ticketPrice", ticketPrice);
		return ticketPrice;
	}

}
