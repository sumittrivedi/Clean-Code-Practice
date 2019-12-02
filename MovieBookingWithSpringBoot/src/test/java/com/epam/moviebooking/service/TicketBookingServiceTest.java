package com.epam.moviebooking.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
class TicketBookingServiceTest {

	
	@Test
	void calculatePrice() {

		assertEquals(new TicketPriceService().calculatePrice(1, 1), 250.00);
	}

}
