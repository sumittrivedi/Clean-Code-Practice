package com.epam.moviebooking.webservices.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.epam.moviebooking.dto.SeatInfoDto;
import com.epam.moviebooking.service.TicketPriceService;

@RestController
public class TicketPriceRestController {
	
	@Autowired
	private TicketPriceService ticketPriceService;
	
	@PostMapping(value = "restTicketPrice")
	public Double ticketPriceRestController(@RequestBody ArrayList<SeatInfoDto> seatInfos)
	{
		Double ticketPrice = ticketPriceService.calculatePrice(seatInfos);
		System.out.println("RestController"+ticketPrice);
		return ticketPrice;
	}

}
