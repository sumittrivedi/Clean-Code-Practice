package com.epam.movieTicketBooking.service;

import com.epam.movieTicketBooking.dao.LocationDao;
import com.epam.movieTicketBooking.daoImpl.LocationDaoImpl;

public class LocationService {
	
	LocationDao locatiobnDao = new LocationDaoImpl();
	
	public void showLocation()
	{
		locatiobnDao.showLocation();
	}
	
}
