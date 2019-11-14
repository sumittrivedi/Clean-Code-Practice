package service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import dao.LocationDao;
import dto.LocationDto;

public class LocationServiceTest {

	@Mock
	LocationDao locationDao;
	
	@InjectMocks
	LocationService locationService;
	
	@Before
	public void init()
	{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testAll()
	{
		ArrayList<LocationDto> locations = new ArrayList<LocationDto>();
		
			LocationDto locationDto = new LocationDto();
			locationDto.setLocationName("Hyderabad");
			locations.add(locationDto);
			
			LocationDto locationDto1 = new LocationDto();
			locationDto1.setLocationName("Kolkata");
			locations.add(locationDto1);
			
			LocationDto locationDto2 = new LocationDto();
			locationDto2.setLocationName("Chennai");
			locations.add(locationDto2);
			
			LocationDto locationDto3 = new LocationDto();
			locationDto3.setLocationName("Patna");
			locations.add(locationDto3);
			
			LocationDto locationDto4 = new LocationDto();
			locationDto4.setLocationName("Delhi");
			locations.add(locationDto4);
			
			LocationDto locationDto5 = new LocationDto();
			locationDto5.setLocationName("Pune");
			locations.add(locationDto5);
			
			LocationDto locationDto6 = new LocationDto();
			locationDto6.setLocationName("Banglore");
			locations.add(locationDto6);
		
		when(locationDao.getLocation()).thenReturn(locations);
		assertEquals(locations, locationDao.getLocation());
		
		
	}
}
