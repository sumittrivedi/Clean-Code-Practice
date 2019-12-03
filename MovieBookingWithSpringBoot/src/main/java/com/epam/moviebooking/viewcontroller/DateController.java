package com.epam.moviebooking.viewcontroller;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.epam.moviebooking.webservices.restclient.DateRestClient;

@Controller
public class DateController {
	
	@Autowired
	private DateRestClient dateRestClient;
	
	@GetMapping(value="date")
	public ModelAndView DateServlet(@RequestParam String theatreChoice,HttpSession session)
	{
		ModelAndView mv = new ModelAndView();
		session.setAttribute("theatreChoice", theatreChoice);
		List<LocalDate> dateList = dateRestClient.getDate();
		mv.addObject("dateList", dateList);
		mv.setViewName("date");
		return mv;
	}

}
