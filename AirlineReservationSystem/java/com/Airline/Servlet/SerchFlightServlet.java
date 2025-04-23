package com.Airline.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;

import com.Airline.Service.FlightService;
import com.Airline.entity.Flight;

/**
 * Servlet implementation class SerchFlightServlet
 */
@WebServlet("/serchFlight")
public class SerchFlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SerchFlightServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String source = request.getParameter("from");
		String destination = request.getParameter("to");
		LocalDate date = LocalDate.parse(request.getParameter("date"));
		
		List<Flight> flights = new FlightService().serchFlight(source, destination, date);
		
		if(!flights.isEmpty()) {
			flights.stream().forEach(f ->System.out.println(f));
			request.setAttribute("flights", flights);
			request.getRequestDispatcher("serch-result.jsp").forward(request, response);
			
		}else {
			out.println("<h2>No Flight available! , plsese search again</h2>");
			request.getRequestDispatcher("search.jsp").include(request, response);
		}
	}

}
