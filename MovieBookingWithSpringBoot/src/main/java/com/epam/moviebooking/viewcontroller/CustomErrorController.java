package com.epam.moviebooking.viewcontroller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {
	
	private static final String PATH = "/error";
	
	@RequestMapping(value = PATH)
	public String errorMsg()
	{
		return "error";
	}

	 @Override
	    public String getErrorPath() {
	        return PATH;
	    }
}
