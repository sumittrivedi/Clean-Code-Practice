package com.epam.moviebooking.viewcontroller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.epam.moviebooking.dto.AvailableSeatDto;
import com.epam.moviebooking.service.ShowDetailsService;
import com.epam.moviebooking.service.TheatreService;
import com.epam.moviebooking.webservices.restclient.SeatAvailabilityRestClient;

@Controller
public class SeatAvailabiltyController {

	@Autowired
	private SeatAvailabilityRestClient seatAvailabilityRestClient;
	@Autowired
	private TheatreService theatreService;
	@Autowired
	private ShowDetailsService showDetailsService;
	
	@RequestMapping("seatAvailabilty")
	public ModelAndView SeatAvailabilityServlet(@RequestParam String timeChoice,HttpSession session)
	{
	
		ModelAndView mv = new ModelAndView();
		session.setAttribute("timeChoice", timeChoice);
		String dateChoice =  (String) session.getAttribute("dateChoice");
		String theatreChoice =  (String) session.getAttribute("theatreChoice");
		int theatreId = theatreService.getTheatreId(theatreChoice);
		int showId = showDetailsService.getShowId(theatreId, dateChoice, timeChoice);	
		AvailableSeatDto availableSeatDto = seatAvailabilityRestClient.getAvailableSeat(showId);
		session.setAttribute("availableSeatDto", availableSeatDto);
		mv.setViewName("seatAvailability");
		return mv;
	}
}
