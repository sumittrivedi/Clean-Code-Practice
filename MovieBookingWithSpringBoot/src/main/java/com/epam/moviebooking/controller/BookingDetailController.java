package com.epam.moviebooking.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.epam.moviebooking.dto.TicketBookingDto;
import com.epam.moviebooking.service.TicketBookingService;

@RestController
public class BookingDetailController {

	@Autowired
	private TicketBookingService ticketBookingService;
	
	@RequestMapping("bookingDetail")
	public ModelAndView BookingDetailServlet(@RequestParam String cus_name, @RequestParam String contact_no, HttpSession session)
	{
		ModelAndView mv = new ModelAndView();
		session.setAttribute("cus_name", cus_name);
		session.setAttribute("contact_no", contact_no);
		String locationChoice = (String) session.getAttribute("locationChoice"); 
		String movieChoice = (String) session.getAttribute("movieChoice");
		String theatreChoice = (String) session.getAttribute("theatreChoice");
		String dateChoice = (String) session.getAttribute("dateChoice");
		String timeChoice = (String) session.getAttribute("timeChoice");
		int premiumSeatChoice = (int) session.getAttribute("premiumSeatChoice");
		int executiveSeatChoice = (int) session.getAttribute("executiveSeatChoice");
		Double ticketPrice = (Double) session.getAttribute("ticketPrice");
		
		TicketBookingDto dto = new TicketBookingDto();
		dto.setLocationName(locationChoice);
		dto.setMovieName(movieChoice);
		dto.setTheatreName(theatreChoice);
		dto.setDate(dateChoice);
		dto.setTime(timeChoice);	
		dto.setPremiumSeats(premiumSeatChoice);
		dto.setExecutiveSeats(executiveSeatChoice);
		dto.setPrice(ticketPrice);
		dto.setCustomerName(cus_name);
		dto.setMobileNo(contact_no);
		
		ticketBookingService.setTicketBookingDetails(dto);
		mv.setViewName("bookingDetail");
		return mv;
	}
}
