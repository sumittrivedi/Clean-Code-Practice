package com.epam.moviebooking.service;

import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;
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

	public void addLocation(String locationName) throws GeneralSecurityException {
		LocationDto locationDto = new LocationDto();
		Random random = SecureRandom.getInstanceStrong();
		int id = random.nextInt();
		locationDto.setLocationId(id);
		locationDto.setLocationName(locationName);
		locationRepository.save(locationDto);
	}
	public void deleteLocation(int locationId)
	{
		Optional<LocationDto> locationDto = locationRepository.findById(locationId);
		if (locationDto.isPresent()) 
			locationRepository.delete(locationDto.get());
	}

	public void updateLocation(int locationId, String locationName)
	{
		Optional<LocationDto> locationDtoOptional = locationRepository.findById(locationId);
		LocationDto locationDto = null;
		if (locationDtoOptional.isPresent()) 
		{
			locationDto = locationDtoOptional.get();
			locationDto.setLocationName(locationName);
			locationRepository.save(locationDto);
		}
	}
}
