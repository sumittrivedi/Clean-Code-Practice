package com.epam.moviebooking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.moviebooking.entity.LocationEntity;
import com.epam.moviebooking.repository.LocationRepository;

@Service
public class LocationService {

	@Autowired
	private LocationRepository locationRepository;

	public List<LocationEntity> getLocation() {
		return (List<LocationEntity>) locationRepository.findAll();
	}

	public void addLocation(String locationName) {
		LocationEntity locationDto = new LocationEntity();
		locationDto.setLocationName(locationName);
		locationRepository.save(locationDto);
	}
	public void deleteLocation(int locationId)
	{
		locationRepository.deleteById(locationId);
	}

	public void updateLocation(int locationId, String locationName)
	{
		Optional<LocationEntity> locationDtoOptional = locationRepository.findById(locationId);
		LocationEntity locationDto = null;
		if (locationDtoOptional.isPresent()) 
		{
			locationDto = locationDtoOptional.get();
			locationDto.setLocationName(locationName);
			locationRepository.save(locationDto);
		}
	}
}
