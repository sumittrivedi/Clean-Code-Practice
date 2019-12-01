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

import com.epam.moviebooking.dto.MovieDto;
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
		List<MovieDto> moviedtoList = new ArrayList<MovieDto>();
		MovieDto obj1 = new MovieDto(13,"War",9);
		MovieDto obj2 = new MovieDto(14,"Super 30",10);
		
		moviedtoList.add(obj1);
		moviedtoList.add(obj2);
		
		when(movieRepository.movieByLocation("Chennai")).thenReturn(moviedtoList);
		assertEquals(movieRepository.movieByLocation("Chennai"), moviedtoList);
	}

}
