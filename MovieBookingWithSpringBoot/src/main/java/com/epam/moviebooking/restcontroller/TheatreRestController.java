package com.epam.moviebooking.restcontroller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.epam.moviebooking.dto.TheatreDto;
import com.epam.moviebooking.service.TheatreService;

@RestController
public class TheatreRestController {
	
	@Autowired
	private TheatreService theatreService;
	@GetMapping("theatre")
	
	public List<TheatreDto> TheatreServlet(@RequestParam String movieChoice, HttpSession session)
	{
		session.setAttribute("movieChoice", movieChoice);	
		String locationChoice = (String) session.getAttribute("locationChoice");	
		List<TheatreDto> theatreList = theatreService.theatreByMovie(locationChoice, movieChoice);		
		return theatreList;
	}

}
