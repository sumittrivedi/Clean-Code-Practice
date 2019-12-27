package com.epam.moviebooking.viewcontroller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.epam.moviebooking.dto.TheatreDto;
import com.epam.moviebooking.webservices.restclient.TheatreRestClient;

@RestController
public class TheatreController {
	
	@Autowired
	private TheatreRestClient theatreRestClient;
	
	@RequestMapping(value = "theatre")
	public ModelAndView getTheatre(@RequestParam String movieChoice, HttpSession session)
	{
		ModelAndView mv = new ModelAndView();
		session.setAttribute("movieChoice", movieChoice);	
		String locationChoice = (String) session.getAttribute("locationChoice");	
		List<TheatreDto> theatreList = theatreRestClient.theatreByMovie(locationChoice, movieChoice);		
		mv.addObject("theatreList", theatreList);
		mv.setViewName("theatre");
		return mv;
	}

}
