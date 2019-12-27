package com.epam.moviebooking.viewcontroller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.epam.moviebooking.service.SeatArrangementService;
import com.epam.moviebooking.webservices.restclient.TicketPriceRestClient;

@Controller
public class TicketPriceController {

	@Autowired
	private TicketPriceRestClient ticketPriceRestClient;
	@Autowired
	private SeatArrangementService seatArrangementService;
	
	@RequestMapping(value = "ticketPrice")
	public ModelAndView getTicketPrice(@RequestParam String seatInfos,HttpSession session) 
	{
		ModelAndView mv = new ModelAndView();
		String seatIds = seatArrangementService.getSeatIds(seatInfos);
		session.setAttribute("seatIds", seatIds);
		Double totalticketPrice = ticketPriceRestClient.calculatePrice(seatInfos);
		session.setAttribute("totalticketPrice", totalticketPrice);
		mv.addObject("totalticketPrice", totalticketPrice);
		mv.setViewName("ticketPrice");
		return mv;
	}
}
