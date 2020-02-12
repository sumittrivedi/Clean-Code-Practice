package com.epam.moviebooking.viewcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.epam.moviebooking.entity.LocationEntity;
import com.epam.moviebooking.service.LocationService;
import com.epam.moviebooking.webservices.restclient.LocationRestclient;

@Controller
public class LocationController {
	
	@Autowired
	private LocationRestclient locationRestclient;
	@Autowired
	private LocationService locationService;
	@Autowired
	private AdminController adminController;
	
	@GetMapping(value = "location")
	public ModelAndView getLocation()
	{
		List<LocationEntity> locationList = locationRestclient.getLocation();
		ModelAndView mv = new ModelAndView();
		mv.addObject("locationList", locationList);
		mv.setViewName("location");
		return mv;
	}
	
	@PostMapping(value = "addLocation")
	public ModelAndView addLocation(@RequestParam String locationName)
	{
		locationService.addLocation(locationName);
		return adminController.locationDetails();
	}
	@PostMapping(value = "deleteLocation")
	public ModelAndView deleteLocation(@RequestParam int locationId)
	{
		locationService.deleteLocation(locationId);
		return adminController.locationDetails();
	}
	
	@PostMapping(value = "updateLocation")
	public ModelAndView updateLocation(@RequestParam int locationId,@RequestParam String locationName)
	{
		locationService.updateLocation(locationId,locationName);
		return adminController.locationDetails();
	}
}

