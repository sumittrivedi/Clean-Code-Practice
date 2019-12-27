package com.epam.moviebooking.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.moviebooking.repository.LocationRepository;
import com.epam.moviebooking.dto.LocationDto;

@Service
public class LocationService {

	@Autowired
	private LocationRepository locationRepository;

	public List<LocationDto> getLocation() {
		return (List<LocationDto>) locationRepository.findAll();
	}

	public void addLocation(String locationName) {
		LocationDto locationDto = new LocationDto();
		Random random = new Random();
		int id = random.nextInt();
		locationDto.setLocationId(id);
		locationDto.setLocationName(locationName);
		locationRepository.save(locationDto);
	}

}
