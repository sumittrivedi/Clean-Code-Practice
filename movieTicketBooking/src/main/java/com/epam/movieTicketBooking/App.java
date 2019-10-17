package com.epam.movieTicketBooking;

import java.util.Scanner;

import org.slf4j.*;

import com.epam.movieTicketBooking.service.LocationService;
import com.epam.movieTicketBooking.service.MovieService;
import com.epam.movieTicketBooking.service.TheatreService;
import com.epam.movieTicketBooking.service.TicketService;
import com.epam.movieTicketBooking.utilities.CollectionDB;

public class App {
	private static final Logger logger = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		
		CollectionDB.getInstance();
		Scanner userChoice = new Scanner(System.in);
		logger.info("Location where we serve");
		
		
		new LocationService().showLocation();
		logger.info("Choose Location :");
		String locationChoice = userChoice.nextLine();
		
		
		new MovieService().showMovie(locationChoice);
		logger.info("Choose Movie :");
		String movieChoice = userChoice.nextLine();
		
		new TheatreService().showTheartre(locationChoice, movieChoice);
		
		new TicketService().showTicketType();
		logger.info("Choose Ticket type :");
		String ticketChoice = userChoice.nextLine();
		
		logger.info("Enter number of seats :");
		int noOfSeats = userChoice.nextInt();
		
		logger.info("Total Price  = {}",new TicketService().calculatePrice(ticketChoice, noOfSeats));
		
		userChoice.close();
	}
}
