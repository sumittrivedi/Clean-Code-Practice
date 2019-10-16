package com.epam.movieTicketBooking.service;

import com.epam.movieTicketBooking.daoImpl.LocationDaoImpl;

public class LocationService {
	
	public void showLocation()
	{
		new LocationDaoImpl().showLocation();
	}
	
	public void addLocation()
	{
		new LocationDaoImpl().addLocation();
	}
}
