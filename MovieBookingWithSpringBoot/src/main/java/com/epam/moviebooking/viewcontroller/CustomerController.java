package com.epam.moviebooking.viewcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {

	@GetMapping(value = "customer")
	public ModelAndView customerServlet()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("customer");
		return mv;
	}
}
