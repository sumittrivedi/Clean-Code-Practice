package com.epam.moviebooking.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.epam.moviebooking.entity.MovieEntity;
import com.epam.moviebooking.repository.MovieRepository;


class MovieServiceTest {
	
	@Mock
	MovieRepository movieRepository;
	@InjectMocks
	MovieService movieService;
	
	@BeforeEach
	public void init()
	{
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void getMovie() 
	{
		List<MovieEntity> moviedtoList = new ArrayList<MovieEntity>();
		MovieEntity obj1 = new MovieEntity(13,"War",9);
		MovieEntity obj2 = new MovieEntity(14,"Super 30",10);
		
		moviedtoList.add(obj1);
		moviedtoList.add(obj2);
		
		when(movieRepository.movieByLocation("Chennai")).thenReturn(moviedtoList);
		assertEquals(movieRepository.movieByLocation("Chennai"), moviedtoList);
	}

}
