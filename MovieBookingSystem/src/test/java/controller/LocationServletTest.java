package controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import dto.LocationDto;
import service.LocationService;

public class LocationServletTest {

	@Mock
	LocationService locationservice;
	@Mock
	HttpServletRequest request;
	@Mock
	HttpServletResponse response;
	@Mock
	RequestDispatcher rd;
	@Mock
	ArrayList<LocationDto> locations;
	@InjectMocks
	LocationServlet locationServlet;
	
	@Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	 public void test() throws IOException, ServletException {		
		
		when(locationservice.getLocation()).thenReturn(locations);
		when(request.getRequestDispatcher("location.jsp")).thenReturn(rd);
		locationServlet.doGet(request, response);
		assertEquals(locations, locationservice.getLocation());
		verify(rd).forward(request, response);
		
	}
}
