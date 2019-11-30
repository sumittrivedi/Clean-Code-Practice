package com.epam.moviebooking.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.epam.moviebooking.dto.TheatreDto;
import com.epam.moviebooking.service.TheatreService;

@RestController
public class TheatreController {
	
	@Autowired
	private TheatreService theatreService;
	@RequestMapping("theatre")
	public ModelAndView TheatreServlet(@RequestParam String movieChoice, HttpSession session)
	{
		ModelAndView mv = new ModelAndView();
		session.setAttribute("movieChoice", movieChoice);	
		String locationChoice = (String) session.getAttribute("locationChoice");	
		List<TheatreDto> theatreList = theatreService.theatreByMovie(locationChoice, movieChoice);		
		mv.addObject("theatreList", theatreList);
		mv.setViewName("theatre");
		return mv;
	}

}
