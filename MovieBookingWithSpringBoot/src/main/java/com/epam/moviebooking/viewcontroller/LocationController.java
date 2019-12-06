package com.epam.moviebooking.viewcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.epam.moviebooking.dto.LocationDto;
import com.epam.moviebooking.webservices.restclient.LocationRestclient;

@Controller
public class LocationController {
	
	@Autowired
	private LocationRestclient locationRestclient;
	
	@RequestMapping("location")
	public ModelAndView getLocation()
	{
		List<LocationDto> locationList = locationRestclient.getLocation();
		ModelAndView mv = new ModelAndView();
		mv.addObject("locationList", locationList);
		mv.setViewName("location");
		return mv;
	}
}
