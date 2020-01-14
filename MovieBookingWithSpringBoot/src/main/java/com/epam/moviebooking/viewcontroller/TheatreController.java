package com.epam.moviebooking.viewcontroller;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.epam.moviebooking.dto.TheatreDto;
import com.epam.moviebooking.service.TheatreService;
import com.epam.moviebooking.webservices.restclient.TheatreRestClient;

@RestController
public class TheatreController {
	
	@Autowired
	private TheatreRestClient theatreRestClient;
	@Autowired
	private AdminController adminController;
	@Autowired 
	private TheatreService theatreService;
	
	@GetMapping(value = "theatre")
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
	
	@PostMapping(value = "addTheatre")
	public ModelAndView addTheatre(@RequestParam String theatreName,@RequestParam int locationId) throws NoSuchAlgorithmException
	{
		theatreService.addTheatre(theatreName, locationId);
		ModelAndView mv = adminController.theatreDetails();
		return mv;
	}
	
	@PostMapping(value = "updateTheatre")
	public ModelAndView updateTheatre(@RequestParam int theatreId,@RequestParam String theatreName,@RequestParam int locationId)
	{
		theatreService.updateTheatre(theatreId, theatreName, locationId);
		return adminController.theatreDetails();
	}
	@PostMapping(value = "deleteTheatre")
	public ModelAndView deleteTheatre(@RequestParam int theatreId)
	{
		theatreService.deleteTheatre(theatreId);
		ModelAndView mv = adminController.theatreDetails();
		return mv;
	}
	
}
