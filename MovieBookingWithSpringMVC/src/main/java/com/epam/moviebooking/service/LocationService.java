package com.epam.moviebooking.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.epam.moviebooking.dao.LocationDao;
import com.epam.moviebooking.daoImpl.LocationDaoImpl;

@Service
public class LocationService {
	
	LocationDao locationDao = new LocationDaoImpl();
	
	public List<String> getLocation()
	{
		return locationDao.getLocation();
	}
	
}
