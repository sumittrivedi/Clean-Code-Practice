package service;

import java.util.List;

import dao.TheatreDao;
import daoImpl.TheatreDaoImpl;

public class TheatreService {

	TheatreDao theatreDao = new TheatreDaoImpl();
	public List<String> theatreByMovie(String locationChoice, String movieChoice)
	{
		return theatreDao.theatreByMovie(locationChoice, movieChoice);
	}
	public int getTheatreId(String theatreName)
	{
		return theatreDao.getTheatreId(theatreName);
	}
}
