package com.epam.moviebooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.moviebooking.dto.MovieDto;
import com.epam.moviebooking.repository.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository movieRepository;
	
	public List<MovieDto> movieByLocation(String locationChoice)
	{
		return movieRepository.movieByLocation(locationChoice);
	}
	public List<MovieDto> findAll()
	{
		return (List<MovieDto>) movieRepository.findAll();
	}
}
