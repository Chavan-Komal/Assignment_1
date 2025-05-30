package com.Airline.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.Airline.Service.UserService;
import com.Airline.entity.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String email=request.getParameter("email");
		String password = request.getParameter("password");
		PrintWriter out=response.getWriter();
		User loggedInUser=new UserService().login(email, password);
		 
		if(loggedInUser!=null) {
			out.println("<h2>Welcome "+loggedInUser.getName()+" </h2>");
			HttpSession session=request.getSession();
			 session.setAttribute("userId", loggedInUser.getId());
			response.sendRedirect("search.jsp");
		}
		else{
			 out.println("<h2>Invalid Credentials,try again</h2>");
			request.getRequestDispatcher("login.jsp").include(request, response);
		}
	}

}
