package com.epam.moviebooking.restcontroller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.epam.moviebooking.dto.AvailableSeatDto;
import com.epam.moviebooking.service.SeatAvailabilityService;
import com.epam.moviebooking.service.TicketPriceService;

@RestController
public class TicketPriceController {
	
	@Autowired
	private TicketPriceService ticketPriceService;
	@Autowired
	private SeatAvailabilityService seatAvailabilityService;
	
	@RequestMapping("ticketPrice")
	public ModelAndView TicketPriceServlet(@RequestParam int premiumSeatChoice ,@RequestParam int executiveSeatChoice ,HttpSession session)
	{
		ModelAndView mv = new ModelAndView();
		session.setAttribute("premiumSeatChoice", premiumSeatChoice);
		session.setAttribute("executiveSeatChoice", executiveSeatChoice);
		AvailableSeatDto availableSeatDto = (AvailableSeatDto) session.getAttribute("availableSeatDto");
		seatAvailabilityService.updateSeats(availableSeatDto,premiumSeatChoice,executiveSeatChoice);
		Double ticketPrice = ticketPriceService.calculatePrice(premiumSeatChoice,executiveSeatChoice);
		session.setAttribute("ticketPrice", ticketPrice);
		mv.setViewName("ticketPrice");
		return mv;
	}

}
