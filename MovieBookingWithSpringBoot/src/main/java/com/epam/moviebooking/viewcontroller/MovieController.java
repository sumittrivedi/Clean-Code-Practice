package com.epam.moviebooking.viewcontroller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.epam.moviebooking.dto.MovieDto;
import com.epam.moviebooking.webservices.restclient.MovieRestClient;

@Controller
public class MovieController {
	
	@Autowired
	private MovieRestClient movieRestClient;
	
	@RequestMapping("movie")
	public ModelAndView movieServlet(@RequestParam("locationChoice") String locationChoice,HttpSession session )
	{
		ModelAndView mv = new ModelAndView();
		session.setAttribute("locationChoice", locationChoice);
		List<MovieDto> movieList = movieRestClient.movieByLocation(locationChoice);
		mv.addObject("movieList", movieList);
		mv.setViewName("movie");
		return mv;
	}

}
