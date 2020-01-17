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

import com.epam.moviebooking.entity.LocationEntity;
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
		List<LocationEntity> locationDtoList = new ArrayList<LocationEntity>();
		LocationEntity obj1 = new LocationEntity(1, "Hyderabad");
		LocationEntity obj2 = new LocationEntity(2, "Kolkata");
		LocationEntity obj3 = new LocationEntity(3, "Chennai");
		LocationEntity obj4 = new LocationEntity(4, "Patna");
		LocationEntity obj5 = new LocationEntity(5, "Delhi");
		LocationEntity obj6 = new LocationEntity(6, "Pune");
		LocationEntity obj7 = new LocationEntity(7, "Banglore");
		
		locationDtoList.add(obj1);
		locationDtoList.add(obj2);
		locationDtoList.add(obj3);
		locationDtoList.add(obj4);
		locationDtoList.add(obj5);
		locationDtoList.add(obj6);
		locationDtoList.add(obj7);
		
		
		when((List<LocationEntity>)locationRepository.findAll()).thenReturn(locationDtoList);
		assertEquals(locationRepository.findAll(), locationDtoList);
	}

}
