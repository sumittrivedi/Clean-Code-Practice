package com.epam.movieTicketBooking.utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import com.epam.movieTicketBooking.dto.LocationDto;
import com.epam.movieTicketBooking.dto.MovieDto;
import com.epam.movieTicketBooking.dto.TicketDto;

public class CollectionDB {
	
	private static CollectionDB db_connection;
	
	public static HashSet<LocationDto> locations = new HashSet<LocationDto>();
	public static HashMap<String, ArrayList<String>> movies= new HashMap<String, ArrayList<String>>();
	public static HashMap<MovieDto, String> theatres = new HashMap<MovieDto, String>();
	public static ArrayList<TicketDto> ticket = new ArrayList<TicketDto>();
	
	private CollectionDB() {
		
		locations.add(new LocationDto("Hyderabad"));
		locations.add(new LocationDto("Kolkata"));
		locations.add(new LocationDto("Banglore"));
		
		movies.put("Hyderabad", new ArrayList<String>(Arrays.asList("Dabang","War","Dream Girl","Uri")));
		movies.put("Kolkata", new ArrayList<String>(Arrays.asList("Joker","War","Dream Girl","Uri")));
		movies.put("Banglore", new ArrayList<String>(Arrays.asList("Joker","Dream Girl","Uri")));
		
		theatres.put(new MovieDto("Hyderabad", "Dabang"), "PVR 10:00 am");
		theatres.put(new MovieDto("Hyderabad", "War"), "INOX 12:00 am");
		theatres.put(new MovieDto("Hyderabad", "Dream girl"), "Cinepolis 1:00 pm");
		theatres.put(new MovieDto("Hyderabad", "Uri"), "Carnival 11:00 am");
		theatres.put(new MovieDto("Banglore", "Dabang"), "PVR 12:15 pm");
		theatres.put(new MovieDto("Banglore", "Uri"), "Cinepolis 02:00 pm");
		theatres.put(new MovieDto("Banglore", "Dream girl"), "PVR 10:00 am");
		theatres.put(new MovieDto("Banglore", "Joker"), "INOX 10:00 am");
		theatres.put(new MovieDto("Kolkata", "Joker"), "Carnival 10:20 am");
		theatres.put(new MovieDto("Kolkata", "War"), "PVR 11:10 am");
		theatres.put(new MovieDto("Kolkata", "Uri"), "Carnival 01:30 pm");
		theatres.put(new MovieDto("Kolkata", "Dream Girl"), "INOX 05:00 pm");
		
		CollectionDB.ticket.add(new TicketDto("Premium", 200.00));
		CollectionDB.ticket.add(new TicketDto("Executive", 150.00));
	
	}
	
	public static CollectionDB getInstance() 
    { 
        if (db_connection == null) 
        	db_connection = new CollectionDB(); 
        return db_connection; 
    } 
	
}