package service;

import java.util.ArrayList;
import dao.MovieDao;
import daoImpl.MovieDaoImpl;
import dto.MovieDto;

public class MovieService {
	
	MovieDao movieDao = new MovieDaoImpl();
	
	public ArrayList<MovieDto> movieByLocation(String locationChoice)
	{
		return movieDao.movieByLocation(locationChoice);
	}
}
