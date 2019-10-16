package com.epam.movieTicketBooking.daoImpl;

import java.util.Iterator;
import org.slf4j.*;

import com.epam.movieTicketBooking.dao.LocationDao;
import com.epam.movieTicketBooking.dto.LocationDto;
import com.epam.movieTicketBooking.utilities.CollectionDB;

public class LocationDaoImpl implements LocationDao {
	
	private static final Logger logger = LoggerFactory.getLogger(LocationDaoImpl.class);
	
	public void addLocation()
	{
		CollectionDB.locations.add(new LocationDto("Hyderabad"));
		CollectionDB.locations.add(new LocationDto("Kolkata"));
		CollectionDB.locations.add(new LocationDto("Banglore"));
	}
	
	public void showLocation()
	{
		Iterator<LocationDto> iterator = CollectionDB.locations.iterator();
		while (iterator.hasNext())
			logger.info(iterator.next().getLocationName());
	}
}
