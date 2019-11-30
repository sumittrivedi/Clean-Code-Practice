package com.epam.moviebooking.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.epam.moviebooking.dto.MovieDto;
import com.epam.moviebooking.service.MovieService;

@RestController
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@RequestMapping("movie")
	public ModelAndView movieServlet(@RequestParam("locationChoice") String locationChoice,HttpSession session )
	{
		ModelAndView mv = new ModelAndView();
		session.setAttribute("locationChoice", locationChoice);
		List<MovieDto> movieList = movieService.movieByLocation(locationChoice);
		mv.addObject("movieList", movieList);
		mv.setViewName("movie");
		return mv;
	}

}
