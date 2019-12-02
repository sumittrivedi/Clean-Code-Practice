package com.epam.moviebooking.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.epam.moviebooking.dto.LocationDto;
import com.epam.moviebooking.repository.LocationRepository;


class LocationServiceTest {
	
	@Mock
	 LocationRepository locationRepository;
	
	@InjectMocks
	 LocationService locationService;
	
	@BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

	@Test
	void getLocation() 
	{
		List<LocationDto> locationDtoList = new ArrayList<LocationDto>();
		LocationDto obj1 = new LocationDto(1, "Hyderabad");
		LocationDto obj2 = new LocationDto(2, "Kolkata");
		LocationDto obj3 = new LocationDto(3, "Chennai");
		LocationDto obj4 = new LocationDto(4, "Patna");
		LocationDto obj5 = new LocationDto(5, "Delhi");
		LocationDto obj6 = new LocationDto(6, "Pune");
		LocationDto obj7 = new LocationDto(7, "Banglore");
		
		locationDtoList.add(obj1);
		locationDtoList.add(obj2);
		locationDtoList.add(obj3);
		locationDtoList.add(obj4);
		locationDtoList.add(obj5);
		locationDtoList.add(obj6);
		locationDtoList.add(obj7);
		
		
		when((List<LocationDto>)locationRepository.findAll()).thenReturn(locationDtoList);
		assertEquals(locationRepository.findAll(), locationDtoList);
	}

}
