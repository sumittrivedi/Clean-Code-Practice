package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.TicketBookingDto;
import service.TicketBookingService;

public class BookingDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cus_name = request.getParameter("cus_name");
		String contact_no = request.getParameter("contact_no");
		
		HttpSession session = request.getSession();
		session.setAttribute("cus_name", cus_name);
		session.setAttribute("contact_no", contact_no);
		
		String locationChoice = (String) session.getAttribute("locationChoice"); 
		String movieChoice = (String) session.getAttribute("movieChoice");
		String theatreChoice = (String) session.getAttribute("theatreChoice");
		String dateChoice = (String) session.getAttribute("dateChoice");
		String timeChoice = (String) session.getAttribute("timeChoice");
		int premiumSeatChoice = (int) session.getAttribute("premiumSeatChoice");
		int executiveSeatChoice = (int) session.getAttribute("executiveSeatChoice");
		Double ticketPrice = (Double) session.getAttribute("ticketPrice");
		
		TicketBookingDto dto = new TicketBookingDto();
		dto.setLocationName(locationChoice);
		dto.setMovieName(movieChoice);
		dto.setTheatreName(theatreChoice);
		dto.setDate(dateChoice);
		dto.setTime(timeChoice);	
		dto.setPremiumSeats(premiumSeatChoice);
		dto.setExecutiveSeats(executiveSeatChoice);
		dto.setPrice(ticketPrice);
		dto.setCustomerName(cus_name);
		dto.setMobileNo(contact_no);
		
		new TicketBookingService().setTicketBookingDetails(dto);
		request.getRequestDispatcher("bookingDetail.jsp").forward(request, response);
	}

}
