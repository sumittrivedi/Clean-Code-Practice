package com.epam.movieTicketBooking;

import java.util.InputMismatchException;
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
		LocationService locationService = new LocationService();
		MovieService movieService = new MovieService();
		TheatreService theatreService = new TheatreService();
		TicketService ticketService = new TicketService();
		String locationChoice, movieChoice, ticketChoice;
		int noOfSeats = 0;

		logger.info("Location where we serve");

		locationService.showLocation();
		logger.info("Choose Location :");
		locationChoice = userChoice.nextLine();

		movieService.showMovie(locationChoice);
		logger.info("Choose Movie :");
		movieChoice = userChoice.nextLine();

		theatreService.showTheartre(locationChoice, movieChoice);

		ticketService.showTicketType();
		logger.info("Choose Ticket type :");
		ticketChoice = userChoice.nextLine();

		try {
			logger.info("Enter number of seats :");
			noOfSeats = userChoice.nextInt();
		} catch (InputMismatchException exception) {
			logger.warn("Please enter valid number of seats", exception);
		}
		
		logger.info("Total Price  = {}", new TicketService().calculatePrice(ticketChoice, noOfSeats));
		userChoice.close();
	}
}
