package com.epam.moviebooking.daoImpl;

import java.util.List;
import javax.persistence.Query;

import com.epam.moviebooking.dao.MovieDao;
import com.epam.moviebooking.utilities.ConnectionFactory;

public class MovieDaoImpl implements MovieDao {

	private static final String  GET_MovieByLocation = "select distinct MovieName from moviedetails where moviedetails.TheatreID IN (select TheatreID from theatredetails where theatredetails.LocationId IN (select LocationId from locationdetails where locationdetails.LocationName = :LocationName))";
	
	@SuppressWarnings("unchecked")
	@Override
	public List<String> movieByLocation(String locationChoice)
	{
		Query query = ConnectionFactory.getEntityManager().createNativeQuery(GET_MovieByLocation);
		query.setParameter("LocationName", locationChoice);
		return query.getResultList();
	}
}