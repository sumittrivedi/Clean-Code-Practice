package com.epam.movieTicketBooking.daoImpl;

import java.util.ArrayList;

import com.epam.movieTicketBooking.dao.LocationDao;
import com.epam.movieTicketBooking.dto.LocationDto;

public class LocationDaoImpl implements LocationDao {
	
	ArrayList<String> locations = new ArrayList<String>();
	
	public void addLocation(String locationName) {
		LocationDto locationDto = new LocationDto();
		locationDto.setLocationName(locationName);
		locations.add(locationDto.getLocationName());
	}

}
