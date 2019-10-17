package com.epam.movieTicketBooking.service;

import com.epam.movieTicketBooking.dao.TheatreDao;
import com.epam.movieTicketBooking.daoImpl.TheatreDaoImpl;

public class TheatreService {

	TheatreDao theatreDao = new TheatreDaoImpl();
	public void showTheartre(String locationChoice, String movieChoice) {
		theatreDao.showTheatre(locationChoice, movieChoice);
	}
}
