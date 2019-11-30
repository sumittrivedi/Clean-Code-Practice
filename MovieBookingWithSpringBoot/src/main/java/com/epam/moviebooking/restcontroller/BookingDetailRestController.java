package com.epam.moviebooking.restcontroller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.epam.moviebooking.dto.TicketBookingDto;
import com.epam.moviebooking.service.TicketBookingService;

@RestController
public class BookingDetailRestController {

	@Autowired
	private TicketBookingService ticketBookingService;
	@Autowired
	private TicketBookingDto ticketBookingDto;
	
	@PostMapping("bookingDetail")
	public TicketBookingDto BookingDetailServlet(@RequestParam String cus_name, @RequestParam String contact_no, HttpSession session)
	{
		
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
		
		ticketBookingDto.setLocationName(locationChoice);
		ticketBookingDto.setMovieName(movieChoice);
		ticketBookingDto.setTheatreName(theatreChoice);
		ticketBookingDto.setDate(dateChoice);
		ticketBookingDto.setTime(timeChoice);	
		ticketBookingDto.setPremiumSeats(premiumSeatChoice);
		ticketBookingDto.setExecutiveSeats(executiveSeatChoice);
		ticketBookingDto.setPrice(ticketPrice);
		ticketBookingDto.setCustomerName(cus_name);
		ticketBookingDto.setMobileNo(contact_no);
		
		TicketBookingDto dto = ticketBookingService.setTicketBookingDetails(ticketBookingDto);
		return dto;
	}
}
