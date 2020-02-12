package com.epam.moviebooking.webservices.restcontroller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.epam.moviebooking.service.DateService;

@RestController
public class DateRestController {
	
	@Autowired
	private DateService dateService;
	
	@GetMapping(value = "restDate", produces={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<LocalDate>> getdate()
	{
		List<LocalDate> dateList = dateService.getDate();
		return new ResponseEntity<>(dateList, HttpStatus.OK);
	}

}
