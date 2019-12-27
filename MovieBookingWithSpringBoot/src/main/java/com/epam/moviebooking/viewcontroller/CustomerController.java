package com.epam.moviebooking.viewcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {

	@RequestMapping(value = "customer")
	public ModelAndView customerServlet()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("customer");
		return mv;
	}
}
