package com.epam.moviebooking.restcontroller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.epam.moviebooking.entity.MovieEntity;
import com.epam.moviebooking.service.MovieService;
import com.epam.moviebooking.webservices.restcontroller.MovieRestController;

@SpringBootTest
class MovieRestControllerTest {
	
	@Mock
	private MovieService movieService;
	@InjectMocks
	private MovieRestController movieRestController;
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void getMovieTest() {
		
		String locationChoice = "Hyderabad";
		List<MovieEntity> movieEntitylist = new ArrayList<>();
		MovieEntity movieEntity = new MovieEntity();
		movieEntity.setMovieId(1);
		movieEntity.setMovieName("Ramayan");
		movieEntity.setTheatreId(1);
		movieEntitylist.add(movieEntity);	
		when(movieService.movieByLocation(locationChoice)).thenReturn(movieEntitylist);
		ResponseEntity<List<MovieEntity>> responseEntity = movieRestController.getMovie(locationChoice);
		assertEquals(responseEntity, movieRestController.getMovie(locationChoice));
	}

	@Test
	void movieDetailsTest() {
		
		List<MovieEntity> movieEntitylist = new ArrayList<>();
		MovieEntity movieEntity = new MovieEntity();
		movieEntity.setMovieId(1);
		movieEntity.setMovieName("Ramayan");
		movieEntity.setTheatreId(1);
		movieEntitylist.add(movieEntity);
		
		when(movieService.findAll()).thenReturn(movieEntitylist);
		ResponseEntity<List<MovieEntity>> responseEntity = movieRestController.movieDetails();
		assertEquals(responseEntity, movieRestController.movieDetails());
	}

}
