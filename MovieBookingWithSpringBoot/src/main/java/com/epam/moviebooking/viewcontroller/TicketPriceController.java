package com.epam.moviebooking.viewcontroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.epam.moviebooking.dto.ShowDetailsDto;
import com.epam.moviebooking.repository.ShowDetailsRepository;
import com.epam.moviebooking.service.ShowDetailsService;
import com.epam.moviebooking.service.TheatreService;
import com.epam.moviebooking.webservices.restclient.TicketPriceRestClient;

@Controller
public class TicketPriceController {

	@Autowired
	private TicketPriceRestClient ticketPriceRestClient;
	@Autowired
	private ShowDetailsService showDetailsService;
	@Autowired
	private TheatreService theatreService;
	@Autowired
	private ShowDetailsRepository showDetailsRepository;
	@Autowired
	private ShowDetailsDto showDetailsDto;

	@RequestMapping(value = "ticketPrice")
	
	public ModelAndView getTicketPrice(@RequestParam String seatInfos,HttpSession session) 
	{
		ModelAndView mv = new ModelAndView();
		String[] selectedSeats = seatInfos.split(",");
		StringBuilder seatIds = new StringBuilder();
		
		Double totalticketPrice = 0.00;
		for (String str : selectedSeats) 
		{
			String[] subStrings = str.split(" ");
			seatIds.append(subStrings[0]+" ");
			totalticketPrice += Double.parseDouble(subStrings[1]);
		}
		
		
		String theatreChoice = (String) session.getAttribute("theatreChoice");
		int theatreId = theatreService.getTheatreId(theatreChoice);
		String date = (String) session.getAttribute("dateChoice");
		String time = (String) session.getAttribute("timeChoice");
		
		String bookedSeats = showDetailsService.getBookedSeats(theatreId, date, time);
		Optional<String> bookedSeatsOptional = Optional.ofNullable(bookedSeats);
		if (bookedSeatsOptional.isPresent()) 
		{
			Optional<ShowDetailsDto> dto = showDetailsRepository.findByTheatreIdAndDateAndTime(theatreId, date, time);
			seatIds.append(bookedSeats);
			dto.get().setBookedSeats(seatIds.toString());
			showDetailsRepository.save(dto.get());
		}
		else
		{
			showDetailsDto.setTheatreId(theatreId);
			showDetailsDto.setDate(date);
			showDetailsDto.setTime(time);
			showDetailsDto.setBookedSeats(seatIds.toString());
			showDetailsRepository.save(showDetailsDto);
		}
//		Double ticketPrice = ticketPriceRestClient.calculatePrice(seatInfos);
//		session.setAttribute("ticketPrice", ticketPrice);
//		mv.setViewName("ticketPrice");
		return mv;
	}
}
