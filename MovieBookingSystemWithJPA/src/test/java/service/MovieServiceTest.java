package service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import dao.MovieDao;
import dto.MovieDto;

public class MovieServiceTest {

	@Mock
	MovieDao movieDao;
	
	@InjectMocks
	MovieService movieService;
	
	@Before
	public void init()
	{
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void testAll()
	{
		ArrayList<MovieDto> arr = new ArrayList<MovieDto>();
		
		MovieDto movieDto = new MovieDto();
		movieDto.setMovieName("Super 30");
		arr.add(movieDto);
		
		MovieDto movieDto1 = new MovieDto();
		movieDto1.setMovieName("War");
		arr.add(movieDto1);
		
		when(movieDao.movieByLocation("Chennai")).thenReturn(arr);
		assertEquals(arr, movieDao.movieByLocation("Chennai"));
	}

}
