package com.epam.movieTicketBooking;

import java.util.Scanner;

import org.slf4j.*;

import com.epam.movieTicketBooking.service.LocationService;
import com.epam.movieTicketBooking.service.MovieService;
import com.epam.movieTicketBooking.service.TheatreService;

public class App {
	private static final Logger logger = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		Scanner userChoice = new Scanner(System.in);

		logger.info("Location where we serve");
		
		new LocationService().addLocation();
		new LocationService().showLocation();
		logger.info("Choose Location :");
		
		String locationChoice = userChoice.nextLine();
		
		new MovieService().addMovie();
		new MovieService().showMovie(locationChoice);
		logger.info("Choose Movie :");
		
		String movieChoice = userChoice.nextLine();
		
		new TheatreService().addTheartre();
		new TheatreService().showTheartre(locationChoice, movieChoice);
		userChoice.close();
	}
}
