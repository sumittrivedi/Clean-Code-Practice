package com.epam.moviebooking.controller;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.epam.moviebooking.dto.TimeDto;
import com.epam.moviebooking.service.TimeService;

@RestController
public class TimeController {
	
	@Autowired
	private TimeService timeService;
	
	@RequestMapping("time")
	public ModelAndView TimeServlet(@RequestParam String dateChoice,HttpSession session)
	{
		LocalDate date = LocalDate.parse(dateChoice);
		ModelAndView mv = new ModelAndView();
		session.setAttribute("dateChoice", dateChoice);
		List<TimeDto> timeList = timeService.getTime(date);
		mv.addObject("timeList", timeList);
		mv.setViewName("time");
		return mv;
	}

}
