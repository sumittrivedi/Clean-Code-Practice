package com.epam.moviebooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.epam.moviebooking.dto.LocationDto;
import com.epam.moviebooking.service.LocationService;

@RestController
public class LocationController {
	
	@Autowired
	LocationService locationservice;
	
	@RequestMapping("location")
	public ModelAndView locationServlet()
	{
		List<LocationDto> locationList = locationservice.getLocation();
		ModelAndView mv = new ModelAndView();
		mv.addObject("locationList", locationList);
		mv.setViewName("location");
		return mv;
	}
}
