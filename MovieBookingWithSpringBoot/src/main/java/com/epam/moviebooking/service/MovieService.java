package com.epam.moviebooking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.moviebooking.entity.MovieEntity;
import com.epam.moviebooking.repository.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository movieRepository;
	@Autowired
	private Optional<MovieEntity> movieEntityOptional;
	
	public List<MovieEntity> movieByLocation(String locationChoice)
	{
		return movieRepository.movieByLocation(locationChoice);
	}
	public List<MovieEntity> findAll()
	{
		return (List<MovieEntity>) movieRepository.findAll();
	}
	
	public void addMovie(String movieName, int theatreId) 
	{
		MovieEntity movieDto = new MovieEntity();
		movieDto.setMovieName(movieName);
		movieDto.setTheatreId(theatreId);
		movieRepository.save(movieDto);
	}
	public void  updateMovie(int movieId, String movieName, int theatreId)
	{
		movieEntityOptional = movieRepository.findById(movieId);
		MovieEntity movieDto = null;
		if (movieEntityOptional.isPresent())
		{
			movieDto = movieEntityOptional.get();
			movieDto.setMovieName(movieName);
			movieDto.setTheatreId(theatreId);
			movieRepository.save(movieDto);
		}
	}
	public void  deleteMovie(int movieId)
	{
		movieRepository.deleteById(movieId);
	}
}
