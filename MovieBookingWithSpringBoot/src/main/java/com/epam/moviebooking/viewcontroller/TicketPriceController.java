package com.epam.moviebooking.viewcontroller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.epam.moviebooking.webservices.restclient.TicketPriceRestClient;

@Controller
public class TicketPriceController {

	@Autowired
	private TicketPriceRestClient ticketPriceRestClient;

	@RequestMapping(value = "ticketPrice")
	public ModelAndView getTicketPrice(@RequestParam int premiumSeatChoice, @RequestParam int executiveSeatChoice,
			HttpSession session) {
		ModelAndView mv = new ModelAndView();
		session.setAttribute("premiumSeatChoice", premiumSeatChoice);
		session.setAttribute("executiveSeatChoice", executiveSeatChoice);
		Double ticketPrice = ticketPriceRestClient.calculatePrice(premiumSeatChoice, executiveSeatChoice);
		session.setAttribute("ticketPrice", ticketPrice);
		mv.setViewName("ticketPrice");
		return mv;
	}
}
