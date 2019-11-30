package com.epam.moviebooking.controller;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.epam.moviebooking.service.DateService;

@RestController
public class DateController {
	
	@Autowired
	private DateService dateService;
	
	@RequestMapping("date")
	public ModelAndView DateServlet(@RequestParam String theatreChoice,HttpSession session)
	{
		ModelAndView mv = new ModelAndView();
		session.setAttribute("theatreChoice", theatreChoice);
		List<LocalDate> dateList = dateService.getDate();
		mv.addObject("dateList", dateList);
		mv.setViewName("date");
		return mv;
	}

}
