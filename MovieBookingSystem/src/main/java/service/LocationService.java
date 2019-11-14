package service;

import java.util.ArrayList;

import dao.LocationDao;
import daoImpl.LocationDaoImpl;
import dto.LocationDto;

public class LocationService {
	
	LocationDao locationDao = new LocationDaoImpl();
	
	public ArrayList<LocationDto> getLocation()
	{
		return locationDao.getLocation();
	}
	
}
