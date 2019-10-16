package com.epam.movieTicketBooking.service;

import com.epam.movieTicketBooking.daoImpl.TheatreDaoImpl;

public class TheatreService {

	public void addTheartre() {
		new TheatreDaoImpl().addTheatre();
	}

	public void showTheartre(String locationChoice, String movieChoice) {
		new TheatreDaoImpl().showTheatre(locationChoice, movieChoice);
	}
}
