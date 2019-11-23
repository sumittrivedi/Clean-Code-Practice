package com.epam.moviebooking.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.epam.moviebooking.dto.AvailableSeatDto;
import com.epam.moviebooking.dto.TicketBookingDto;
import com.epam.moviebooking.service.DateTimeService;
import com.epam.moviebooking.service.LocationService;
import com.epam.moviebooking.service.MovieService;
import com.epam.moviebooking.service.SeatAvailabilityService;
import com.epam.moviebooking.service.ShowDetailsService;
import com.epam.moviebooking.service.TheatreService;
import com.epam.moviebooking.service.TicketBookingService;
import com.epam.moviebooking.service.TicketPriceService;

@Controller
public class MyController {
	
	@Autowired
	LocationService locationservice;
	@Autowired
	MovieService movieService;
	@Autowired
	TheatreService theatreService;
	@Autowired
	DateTimeService dateTimeService;
	@Autowired
	SeatAvailabilityService seatAvailabilityService;
	@Autowired
	ShowDetailsService showDetailsService;
	@Autowired
	TicketPriceService ticketPriceService;
	@Autowired
	TicketBookingService ticketBookingService;
	
	@RequestMapping("location")
	public ModelAndView locationServlet()
	{
		List<String> locationList = locationservice.getLocation();
		ModelAndView mv = new ModelAndView();
		mv.addObject("locationList", locationList);
		mv.setViewName("location");
		return mv;
	}
	
	@RequestMapping("movie")
	public ModelAndView movieServlet(@RequestParam("locationChoice") String locationChoice,HttpSession session )
	{
		ModelAndView mv = new ModelAndView();
		session.setAttribute("locationChoice", locationChoice);
		List<String> movieList = movieService.movieByLocation(locationChoice);
		mv.addObject("movieList", movieList);
		mv.setViewName("movie");
		return mv;
	}
	
	@RequestMapping("theatre")
	public ModelAndView TheatreServlet(@RequestParam String movieChoice, HttpSession session)
	{
		ModelAndView mv = new ModelAndView();
		session.setAttribute("movieChoice", movieChoice);	
		String locationChoice = (String) session.getAttribute("locationChoice");	
		List<String> theatreList = theatreService.theatreByMovie(locationChoice, movieChoice);		
		mv.addObject("theatreList", theatreList);
		mv.setViewName("theatre");
		return mv;
	}

	@RequestMapping("dateTime")
	public ModelAndView DateTimeServlet(@RequestParam String theatreChoice,HttpSession session)
	{
		ModelAndView mv = new ModelAndView();
		session.setAttribute("theatreChoice", theatreChoice);
		ArrayList<String> dateList = dateTimeService.getDate();
		mv.addObject("dateList", dateList);
		List<String> timeList = dateTimeService.getTime();
		mv.addObject("timeList", timeList);
		mv.setViewName("dateTime");
		return mv;
	}
	@RequestMapping("seatAvailabilty")
	public ModelAndView SeatAvailabilityServlet(@RequestParam String dateChoice,@RequestParam String timeChoice,HttpSession session)
	{
		ModelAndView mv = new ModelAndView();
		session.setAttribute("dateChoice", dateChoice);
		session.setAttribute("timeChoice", timeChoice);
		String theatreChoice =  (String) session.getAttribute("theatreChoice");
		int theatreId = theatreService.getTheatreId(theatreChoice);
		int showId = showDetailsService.getShowId(theatreId, dateChoice, timeChoice);	
		AvailableSeatDto availableSeatDto = seatAvailabilityService.getAvailableSeat(showId);
		session.setAttribute("availableSeatDto", availableSeatDto);
		mv.setViewName("seatAvailability");
		return mv;
	}
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
	
	@RequestMapping("customer")
	public ModelAndView CustomerServlet()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("customer");
		return mv;
	}
	
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
