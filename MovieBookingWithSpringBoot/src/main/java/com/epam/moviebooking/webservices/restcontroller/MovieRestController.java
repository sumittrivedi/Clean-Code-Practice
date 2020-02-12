package com.epam.moviebooking.webservices.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.epam.moviebooking.entity.MovieEntity;
import com.epam.moviebooking.service.MovieService;

@RestController
public class MovieRestController {
	
	@Autowired
	private MovieService movieService;
	
	@GetMapping(value = "restMovie", produces={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<MovieEntity>> getMovie(@RequestParam("locationChoice") String locationChoice)
	{
		List<MovieEntity> movieList = movieService.movieByLocation(locationChoice);
		return new ResponseEntity<>(movieList, HttpStatus.OK);
	}
	
	@GetMapping(value = "restMovieDetails", produces={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<MovieEntity>> movieDetails()
	{
		List<MovieEntity> movieList = movieService.findAll();
		return new ResponseEntity<>(movieList, HttpStatus.OK);
	}
}
