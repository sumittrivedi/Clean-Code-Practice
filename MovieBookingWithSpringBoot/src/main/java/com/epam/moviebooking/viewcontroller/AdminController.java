package com.epam.moviebooking.viewcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.epam.moviebooking.dto.LocationDto;
import com.epam.moviebooking.dto.MovieDto;
import com.epam.moviebooking.dto.TheatreDto;
import com.epam.moviebooking.dto.TimeDto;
import com.epam.moviebooking.webservices.restclient.LocationRestclient;
import com.epam.moviebooking.webservices.restclient.MovieRestClient;
import com.epam.moviebooking.webservices.restclient.TheatreRestClient;
import com.epam.moviebooking.webservices.restclient.TimeRestClient;

@Controller
public class AdminController {
	
	@Autowired
	private LocationRestclient locationRestclient;
	@Autowired
	private TheatreRestClient theatreRestClient;
	@Autowired
	private MovieRestClient movieRestClient;
	@Autowired
	private TimeRestClient timeRestClient;
	
	@RequestMapping(value = "admin")
	public String adminPage()
	{
		return "adminHome";
	}
	
	@RequestMapping(value = "locationDetails")
	public ModelAndView locationDetails()
	{
		ModelAndView mv = new ModelAndView();
		List<LocationDto> locationList = locationRestclient.getLocation();
		mv.addObject("locationList", locationList);
		mv.setViewName("locationDetails");
		return mv;
	}
	
	@RequestMapping(value = "theatreDetails")
	public ModelAndView theatreDetails()
	{
		ModelAndView mv = new ModelAndView();
		List<TheatreDto> theatreList = theatreRestClient.theatreDetails();
		mv.addObject("theatreList", theatreList);
		mv.setViewName("theatreDetails");
		return mv;

	}
	
	@RequestMapping(value = "movieDetails")
	public ModelAndView movieDetails()
	{
		ModelAndView mv = new ModelAndView();
		List<MovieDto> movieList = movieRestClient.movieDetails();
		mv.addObject("movieList", movieList);
		mv.setViewName("movieDetails");
		return mv;

	}
	
	@RequestMapping(value = "timeDetails")
	public ModelAndView timeDetails()
	{
		ModelAndView mv = new ModelAndView();
		List<TimeDto> timeList = timeRestClient.timeDetails();
		mv.addObject("timeList", timeList);
		mv.setViewName("timeDetails");
		return mv;

	}
}
