package service;

import java.util.List;

import dao.MovieDao;
import daoImpl.MovieDaoImpl;

public class MovieService {
	
	MovieDao movieDao = new MovieDaoImpl();
	
	public List<String> movieByLocation(String locationChoice)
	{
		return movieDao.movieByLocation(locationChoice);
	}
}
