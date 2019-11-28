package com.epam.moviebooking.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.moviebooking.repository.LocationRepository;
import com.epam.moviebooking.dto.LocationDto;

@Service
public class LocationService {
	
	@Autowired
	LocationRepository locationRepository;
	
	public List<LocationDto> getLocation()
	{
		return (List<LocationDto>)locationRepository.findAll();
	}
	
}
