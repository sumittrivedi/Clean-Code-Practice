package com.epam.moviebooking.viewcontroller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.epam.moviebooking.dto.AvailableSeatDto;
import com.epam.moviebooking.webservices.restclient.SeatAvailabilityRestClient;

@Controller
public class SeatAvailabiltyController {

	@Autowired
	private SeatAvailabilityRestClient seatAvailabilityRestClient;
	
	
	@GetMapping("seatAvailabilty")
	public ModelAndView seatAvailability(@RequestParam String timeChoice,HttpSession session)
	{
	
		ModelAndView mv = new ModelAndView();
		session.setAttribute("timeChoice", timeChoice);
		String dateChoice =  (String) session.getAttribute("dateChoice");
		String theatreChoice =  (String) session.getAttribute("theatreChoice");
		AvailableSeatDto availableSeatDto = seatAvailabilityRestClient.getAvailableSeat(theatreChoice,dateChoice,timeChoice);
		session.setAttribute("availableSeatDto", availableSeatDto);
		mv.setViewName("seatAvailability");
		return mv;
	}
}
