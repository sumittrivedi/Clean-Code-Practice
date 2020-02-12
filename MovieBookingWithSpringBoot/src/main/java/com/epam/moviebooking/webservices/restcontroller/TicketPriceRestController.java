package com.epam.moviebooking.webservices.restcontroller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.epam.moviebooking.service.TicketPriceService;

@RestController
public class TicketPriceRestController {
	
	@Autowired
	private TicketPriceService ticketPriceService;
	
	@GetMapping(value = "restTicketPrice", produces={MediaType.APPLICATION_JSON_VALUE})
	public Double ticketPriceRestController(@RequestParam String seatInfos)
	{
		return ticketPriceService.calculatePrice(seatInfos);
	}

}
