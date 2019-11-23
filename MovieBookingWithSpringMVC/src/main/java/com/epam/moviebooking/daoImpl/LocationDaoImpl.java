package com.epam.moviebooking.daoImpl;
import java.util.List;
import javax.persistence.Query;

import com.epam.moviebooking.dao.LocationDao;
import com.epam.moviebooking.utilities.ConnectionFactory;

public class LocationDaoImpl implements LocationDao{
	
	String selectQuery = "select LocationName  from locationdetails";
	
	@SuppressWarnings("unchecked")
	@Override
	public List<String> getLocation()
	{
		Query query = ConnectionFactory.getEntityManager().createNativeQuery(selectQuery);
		List<String> locations =  query.getResultList();
		return locations;
	}
	
}
