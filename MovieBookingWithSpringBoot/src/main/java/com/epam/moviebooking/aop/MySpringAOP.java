package com.epam.moviebooking.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.moviebooking.entity.TicketBookingEntity;


@Aspect
@Component
public class MySpringAOP {
	
	@Autowired
	TicketBookingEntity ticketBookingDto;

	private static final Logger logger = LoggerFactory.getLogger(MySpringAOP.class);

	@AfterReturning(value = "execution(* getAvailabileSeats(..))", returning = "returnObj")
	public void getAvailabileSeatsRestCon(JoinPoint joinPoint, Object returnObj)
	{
		logger.info(returnObj.toString());
	}
	
	
	
}
