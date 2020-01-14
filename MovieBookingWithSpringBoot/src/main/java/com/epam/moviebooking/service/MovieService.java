package com.epam.moviebooking.service;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.moviebooking.dto.MovieDto;
import com.epam.moviebooking.repository.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository movieRepository;
	@Autowired
	private Optional<MovieDto> movieDtoOptional;
	
	public List<MovieDto> movieByLocation(String locationChoice)
	{
		return movieRepository.movieByLocation(locationChoice);
	}
	public List<MovieDto> findAll()
	{
		return (List<MovieDto>) movieRepository.findAll();
	}
	
	public void addMovie(String movieName, int theatreId) throws NoSuchAlgorithmException
	{
		MovieDto movieDto = new MovieDto();
		Random random = SecureRandom.getInstanceStrong();
		int movieId = random.nextInt();
		movieDto.setMovieId(movieId);
		movieDto.setMovieName(movieName);
		movieDto.setTheatreId(theatreId);
		movieRepository.save(movieDto);
	}
	public void  updateMovie(int movieId, String movieName, int theatreId)
	{
		movieDtoOptional = movieRepository.findById(movieId);
		MovieDto movieDto = null;
		if (movieDtoOptional.isPresent())
		{
			movieDto = movieDtoOptional.get();
			movieDto.setMovieName(movieName);
			movieDto.setTheatreId(theatreId);
			movieRepository.save(movieDto);
		}
	}
	public void  deleteMovie(int movieId)
	{
		movieDtoOptional = movieRepository.findById(movieId);
		MovieDto movieDto = null;
		if (movieDtoOptional.isPresent()) {
			movieDto = movieDtoOptional.get();
			movieRepository.delete(movieDto);
		}
			
	}
}
