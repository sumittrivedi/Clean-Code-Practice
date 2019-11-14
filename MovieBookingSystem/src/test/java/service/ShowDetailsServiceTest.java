package service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import dao.ShowDetailsDao;

public class ShowDetailsServiceTest {

	@Mock
	ShowDetailsDao showDetailsDao;
	@InjectMocks
	ShowDetailsServiceTest showDetailsService;
	
	@Before
	public void init()
	{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getShowIdTest() {
		
		when(showDetailsDao.getShowId(10, "2019-11-11", "8:00 am")).thenReturn(166);
		assertEquals(166, showDetailsDao.getShowId(10, "2019-11-11", "8:00 am"));
		
	}

}
