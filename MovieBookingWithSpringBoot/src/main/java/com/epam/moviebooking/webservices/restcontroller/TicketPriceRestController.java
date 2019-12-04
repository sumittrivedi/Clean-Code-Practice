package com.epam.moviebooking.webservices.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.epam.moviebooking.service.TicketPriceService;

@RestController
public class TicketPriceRestController {
	
	@Autowired
	private TicketPriceService ticketPriceService;
	
	@GetMapping(value = "restTicketPrice/{premiumSeatChoice}/{executiveSeatChoice}")
	public Double ticketPriceRestController(@PathVariable int premiumSeatChoice ,@PathVariable int executiveSeatChoice)
	{
		Double ticketPrice = ticketPriceService.calculatePrice(premiumSeatChoice,executiveSeatChoice);
		return ticketPrice;
	}

}
