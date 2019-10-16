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
	public void addTheatre()
	{	
		CollectionDB.theatres.put(new MovieDto("Hyderabad", "Dabang"), "PVR 10:00 am");
		CollectionDB.theatres.put(new MovieDto("Hyderabad", "War"), "INOX 12:00 am");
		CollectionDB.theatres.put(new MovieDto("Hyderabad", "Dream girl"), "Cinepolis 1:00 pm");
		CollectionDB.theatres.put(new MovieDto("Hyderabad", "Uri"), "Carnival 11:00 am");
		CollectionDB.theatres.put(new MovieDto("Banglore", "Dabang"), "PVR 12:15 pm");
		CollectionDB.theatres.put(new MovieDto("Banglore", "Uri"), "Cinepolis 02:00 pm");
		CollectionDB.theatres.put(new MovieDto("Banglore", "Dream girl"), "PVR 10:00 am");
		CollectionDB.theatres.put(new MovieDto("Banglore", "Joker"), "INOX 10:00 am");
		CollectionDB.theatres.put(new MovieDto("Kolkata", "Joker"), "Carnival 10:20 am");
		CollectionDB.theatres.put(new MovieDto("Kolkata", "War"), "PVR 11:10 am");
		CollectionDB.theatres.put(new MovieDto("Kolkata", "Uri"), "Carnival 01:30 pm");
		CollectionDB.theatres.put(new MovieDto("Kolkata", "Dream Girl"), "INOX 05:00 pm");
	}
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
