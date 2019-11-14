package service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import dao.TimeDao;
import dto.TimeDto;

public class DateTimeServiceTest {
	
	@Mock
	TimeDao timeDao;
	
	@InjectMocks
	DateTimeService dateTimeService;
	
	@Before
	public void init()
	{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getTimeTest() {
		
		ArrayList<TimeDto> times = new ArrayList<TimeDto>();
		
		TimeDto timeDto = new TimeDto();
		timeDto.setTime("8:00 am");
		times.add(timeDto);
		
		TimeDto timeDto1 = new TimeDto();
		timeDto1.setTime("10:15 am");
		times.add(timeDto1);
		
		TimeDto timeDto2 = new TimeDto();
		timeDto2.setTime("12:00 pm");
		times.add(timeDto2);
		
		TimeDto timeDto3 = new TimeDto();
		timeDto3.setTime("4:10 pm");
		times.add(timeDto3);
		
		when(timeDao.getTime()).thenReturn(times);
		assertEquals(times, timeDao.getTime());

	}
	
	
}
