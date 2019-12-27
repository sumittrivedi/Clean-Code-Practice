package com.epam.moviebooking.viewcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.epam.moviebooking.dto.LocationDto;
import com.epam.moviebooking.service.LocationService;
import com.epam.moviebooking.webservices.restclient.LocationRestclient;

@Controller
public class LocationController {
	
	@Autowired
	private LocationRestclient locationRestclient;
	@Autowired
	private LocationService locationService;
	
	@RequestMapping(value = "location")
	public ModelAndView getLocation()
	{
		List<LocationDto> locationList = locationRestclient.getLocation();
		ModelAndView mv = new ModelAndView();
		mv.addObject("locationList", locationList);
		mv.setViewName("location");
		return mv;
	}
	
	@RequestMapping(value = "addLocationInput")
	public String addLocationInput()
	{
		return "addLocation";
	}
	
	@PostMapping(value = "addLocation")
	public ModelAndView addLocation(@RequestParam String locationName)
	{
		ModelAndView mv = new ModelAndView();
		locationService.addLocation(locationName);
		mv.setViewName("adminHome");
		return mv;
	}
}
