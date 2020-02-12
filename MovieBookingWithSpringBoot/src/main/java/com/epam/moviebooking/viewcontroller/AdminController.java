package com.epam.moviebooking.viewcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.epam.moviebooking.entity.LocationEntity;
import com.epam.moviebooking.entity.MovieEntity;
import com.epam.moviebooking.entity.TheatreEntity;
import com.epam.moviebooking.entity.TimeEntity;
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
	
	@GetMapping(value = "admin")
	public String adminPage()
	{
		return "adminHome";
	}
	
	@GetMapping(value = "locationDetails")
	public ModelAndView locationDetails()
	{
		ModelAndView mv = new ModelAndView();
		List<LocationEntity> locationList = locationRestclient.getLocation();
		mv.addObject("locationList", locationList);
		mv.setViewName("locationDetails");
		return mv;
	}
	
	@GetMapping(value = "theatreDetails")
	public ModelAndView theatreDetails()
	{
		ModelAndView mv = new ModelAndView();
		List<TheatreEntity> theatreList = theatreRestClient.theatreDetails();
		mv.addObject("theatreList", theatreList);
		mv.setViewName("theatreDetails");
		return mv;

	}
	
	@GetMapping(value = "movieDetails")
	public ModelAndView movieDetails()
	{
		ModelAndView mv = new ModelAndView();
		List<MovieEntity> movieList = movieRestClient.movieDetails();
		mv.addObject("movieList", movieList);
		mv.setViewName("movieDetails");
		return mv;

	}
	
	@GetMapping(value = "timeDetails")
	public ModelAndView timeDetails()
	{
		ModelAndView mv = new ModelAndView();
		List<TimeEntity> timeList = timeRestClient.timeDetails();
		mv.addObject("timeList", timeList);
		mv.setViewName("timeDetails");
		return mv;

	}
}
