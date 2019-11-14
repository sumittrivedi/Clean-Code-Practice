package service;
import java.util.List;

import dao.LocationDao;
import daoImpl.LocationDaoImpl;
public class LocationService {
	
	LocationDao locationDao = new LocationDaoImpl();
	
	public List<String> getLocation()
	{
		return locationDao.getLocation();
	}
	
}
