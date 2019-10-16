package com.epam.movieTicketBooking.daoImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.*;
import com.epam.movieTicketBooking.dao.MovieDao;
import com.epam.movieTicketBooking.utilities.CollectionDB;

public class MovieDaoImpl implements MovieDao {

	private static final Logger logger = LoggerFactory.getLogger(MovieDaoImpl.class);
	
	public void addMovies() {
		
		CollectionDB.movies.put("Hyderabad", new ArrayList<String>(Arrays.asList("Dabang","War","Dream Girl","Uri")));
		CollectionDB.movies.put("Kolkata", new ArrayList<String>(Arrays.asList("Joker","War","Dream Girl","Uri")));
		CollectionDB.movies.put("Banglore", new ArrayList<String>(Arrays.asList("Joker","Dream Girl","Uri")));
		
	}
	
	public void showMovies(String locationChoice) {
		
		Iterator<Entry<String, ArrayList<String>>> iterateMovies = CollectionDB.movies.entrySet().iterator();	
		while(iterateMovies.hasNext())
		{
			Map.Entry<String, ArrayList<String>> mapElement = iterateMovies.next();
			if(mapElement.getKey().equalsIgnoreCase(locationChoice))
				{
					Iterator<String> iterator = mapElement.getValue().iterator();
					while(iterator.hasNext())
						logger.info(iterator.next().toString());
				}
		}
		
	}
}
