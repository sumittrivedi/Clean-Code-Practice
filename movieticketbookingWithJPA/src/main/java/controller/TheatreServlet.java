package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.TheatreService;

public class TheatreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String movieChoice = request.getParameter("movieChoice");
		
		HttpSession session = request.getSession();
		session.setAttribute("movieChoice", movieChoice);
		
		String locationChoice = (String) session.getAttribute("locationChoice");	
		List<String> theatreList = new TheatreService().theatreByMovie(locationChoice, movieChoice);
		
		request.setAttribute("theatreList", theatreList);
		request.getRequestDispatcher("theatre.jsp").forward(request, response);
		
	}

}
