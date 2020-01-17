package com.epam.moviebooking.viewcontroller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.epam.moviebooking.entity.TicketBookingEntity;
import com.epam.moviebooking.webservices.restclient.BookingDetailRestClient;

@Controller
public class BookingDetailController {

	@Autowired
	private BookingDetailRestClient bookingDetailRestClient;
	@Autowired
	private TicketBookingEntity ticketBookingDto;
	
	@PostMapping("bookingDetail")
	public ModelAndView setBookingDetail(@RequestParam String customerName, @RequestParam String mobileNo, HttpSession session)
	{
		
		ModelAndView mv = new ModelAndView();
		session.setAttribute("customerName", customerName);
		session.setAttribute("mobileNo", mobileNo);
		String locationChoice = (String) session.getAttribute("locationChoice"); 
		String movieChoice = (String) session.getAttribute("movieChoice");
		String theatreChoice = (String) session.getAttribute("theatreChoice");
		String dateChoice = (String) session.getAttribute("dateChoice");
		String timeChoice = (String) session.getAttribute("timeChoice");
		String seatIds = (String) session.getAttribute("seatIds");
		Double totalticketPrice = (Double) session.getAttribute("totalticketPrice");
		
		ticketBookingDto.setLocationName(locationChoice);
		ticketBookingDto.setMovieName(movieChoice);
		ticketBookingDto.setTheatreName(theatreChoice);
		ticketBookingDto.setDate(dateChoice);
		ticketBookingDto.setTime(timeChoice);
		ticketBookingDto.setSeatIds(seatIds);
		ticketBookingDto.setPrice(totalticketPrice);
		ticketBookingDto.setCustomerName(customerName);
		ticketBookingDto.setMobileNo(mobileNo);
		
		TicketBookingEntity ticketDetails = bookingDetailRestClient.setTicketBookingDetails(ticketBookingDto);
		mv.addObject("ticketDetails", ticketDetails);
		mv.setViewName("bookingDetail");
		return mv;
	}
}
