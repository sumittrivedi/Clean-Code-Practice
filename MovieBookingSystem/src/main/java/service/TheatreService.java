package service;

import java.util.ArrayList;

import dao.TheatreDao;
import daoImpl.TheatreDaoImpl;
import dto.TheatreDto;

public class TheatreService {

	TheatreDao theatreDao = new TheatreDaoImpl();
	public ArrayList<TheatreDto> theatreByMovie(String locationChoice, String movieChoice)
	{
		return theatreDao.theatreByMovie(locationChoice, movieChoice);
	}
	public int getTheatreId(String theatreName)
	{
		return theatreDao.getTheatreId(theatreName);
	}
}
