package com.epam.moviebooking.restcontroller;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.epam.moviebooking.service.DateService;

@RestController
public class DateRestController {
	
	@Autowired
	private DateService dateService;
	
	@RequestMapping(value = "date")
	public List<LocalDate> DateServlet(@RequestParam String theatreChoice,HttpSession session)
	{
		session.setAttribute("theatreChoice", theatreChoice);
		List<LocalDate> dateList = dateService.getDate();
		return dateList;
	}

}
