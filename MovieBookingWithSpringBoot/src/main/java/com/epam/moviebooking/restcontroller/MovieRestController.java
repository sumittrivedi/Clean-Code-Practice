package com.epam.moviebooking.restcontroller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.epam.moviebooking.dto.MovieDto;
import com.epam.moviebooking.service.MovieService;

@RestController
public class MovieRestController {
	
	@Autowired
	private MovieService movieService;
	
	@GetMapping(value = "movie", produces={MediaType.APPLICATION_JSON_VALUE})
	public List<MovieDto> movieServlet(@RequestParam("locationChoice") String locationChoice,HttpSession session )
	{
		session.setAttribute("locationChoice", locationChoice);
		List<MovieDto> movieList = movieService.movieByLocation(locationChoice);
		return movieList;
	}

}
