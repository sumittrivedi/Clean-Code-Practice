package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.TimeDto;
import service.DateTimeService;

public class DateTimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String theatreChoice = request.getParameter("theatreChoice");
		HttpSession session = request.getSession();
		session.setAttribute("theatreChoice", theatreChoice);
		DateTimeService dateService = new DateTimeService();
		ArrayList<String> dateList = dateService.getDate();
		request.setAttribute("dateList", dateList);
		ArrayList<TimeDto> timeList = dateService.getTime();
		request.setAttribute("timeList", timeList);
		RequestDispatcher rd = request.getRequestDispatcher("dateTime.jsp");
		rd.forward(request, response);
	}


}
