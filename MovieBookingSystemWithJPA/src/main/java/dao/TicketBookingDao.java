package dao;

import dto.TicketBookingDto;

public interface TicketBookingDao {
	
	void setTicketBookingDetails(TicketBookingDto ticketBookingDto);
	void getTicketBookingDetails(int bookingId);

}
