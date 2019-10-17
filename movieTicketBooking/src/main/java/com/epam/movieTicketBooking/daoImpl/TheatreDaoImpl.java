package com.epam.movieTicketBooking.daoImpl;

import java.util.Iterator;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.epam.movieTicketBooking.dao.TheatreDao;
import com.epam.movieTicketBooking.dto.MovieDto;
import com.epam.movieTicketBooking.utilities.CollectionDB;

public class TheatreDaoImpl implements TheatreDao {
	
	private static final Logger logger = LoggerFactory.getLogger(TheatreDaoImpl.class);
	
	public void showTheatre(String locationChoice, String movieChoice)
	{
		Iterator<Entry<MovieDto, String>> iterateTheatre = CollectionDB.theatres.entrySet().iterator();	
		while(iterateTheatre.hasNext())
		{
			Entry<MovieDto, String> mapElement = iterateTheatre.next();
			MovieDto theatreKey = mapElement.getKey();
			if(theatreKey.getLocationName().equalsIgnoreCase(locationChoice))
				if(theatreKey.getMovieName().equalsIgnoreCase(movieChoice))
					logger.info(mapElement.getValue());
		}
	}
}
