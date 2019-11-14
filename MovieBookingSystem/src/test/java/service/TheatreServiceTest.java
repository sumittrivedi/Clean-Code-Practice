package service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import dao.TheatreDao;
import dto.TheatreDto;

public class TheatreServiceTest {

	@Mock
	TheatreDao theatreDao;
	
	@InjectMocks
	TheatreService theatreService;
	
	@Before
	public void init()
	{
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void testForPatna()
	{
		ArrayList<TheatreDto> arr = new ArrayList<TheatreDto>();
		
		TheatreDto theatre = new TheatreDto();
		theatre.setTheatreName("Sanjay Cinema Frasor road");
		arr.add(theatre);
		
		when(theatreDao.theatreByMovie("Patna", "Housefull 4")).thenReturn(arr);
		assertEquals(arr, theatreDao.theatreByMovie("Patna", "Housefull 4"));
	}
	
	@Test
	public void testForKolkata()
	{
		ArrayList<TheatreDto> arr = new ArrayList<TheatreDto>();
		
		TheatreDto theatre = new TheatreDto();
		theatre.setTheatreName("PVR Salt Lake");
		arr.add(theatre);
		
		when(theatreDao.theatreByMovie("Kolkata", "Tare Zameen Pe")).thenReturn(arr);
		assertEquals(arr, theatreDao.theatreByMovie("Kolkata", "Tare Zameen Pe"));
	}

}
