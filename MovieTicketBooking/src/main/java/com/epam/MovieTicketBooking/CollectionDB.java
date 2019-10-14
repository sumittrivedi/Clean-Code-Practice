package com.epam.MovieTicketBooking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CollectionDB implements DBoperations {

	ArrayList<String> locations = new ArrayList<String>();
	HashMap<String, ArrayList<String>> theatres = new HashMap<String, ArrayList<String>>();

	public void setLocation(String locationName) {

		Location locationDAO = new Location();
		locationDAO.setLocationName("locationName");
		locations.add(locationDAO.getLocationName());

	}

	public void setTheatre(String locationName, String theatreName) {
		
		Iterator<String> iterator = locations.iterator();
		while(iterator.hasNext())
			{
			if(iterator.next() == locationName)
				{
				Theatres theatreDAO = new Theatres();
				theatreDAO.setTheatreName(theatreName);
				theatres.put(locationName, theatreName)
				}
			}
		System.out.println("Please first add Location");
	}
	
	
	/*
	 * public void setMovies(String locationName,String theatreName,String
	  movieName)
	 
	  { 
	  HashMap<Theatres, Movies> theatres = new HashMap<Theatres, Movies>();
	  Iterator<String> iterator = locations.iterator(); 
	  while (iterator.hasNext())
	  { 
	  if((String)iterator.next() == locationName) { 
	  Theatres theatreObj = new
	  Theatres(); Movies movieObj = new Movies();
	  theatreObj.setLocation((String)iterator.next());
	  theatreObj.setTheatreName(theatreName); movieObj.setMovieName(movieName);
	  theatres.put(theatreObj, movieObj); } } }
	 */

	public void display(Object element) {

		Iterator iterator = ((List) element).iterator();
		while (iterator.hasNext())
			System.out.println(iterator.next());
	};

	public void display(Object element, Object choice) {

		Iterator iterator = ((Map) element).entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry mapElement = (Map.Entry) iterator.next();
			if (((String) mapElement.getKey()).equalsIgnoreCase((String) choice)) {
				Iterator itr = ((ArrayList<String>) mapElement.getValue()).iterator();
				while (itr.hasNext())
					System.out.println(itr.next());
				break;
			}
		}
	};

}
