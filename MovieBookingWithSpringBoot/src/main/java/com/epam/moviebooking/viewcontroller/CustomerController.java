package com.epam.moviebooking.viewcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {

	@RequestMapping("customer")
	public ModelAndView CustomerServlet()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("customer");
		return mv;
	}
}
