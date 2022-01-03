package com.timesheet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.timesheet.daoimpl.AdminDAOimpl;
import com.timesheet.daoimpl.UserDAOimpl;
import com.timesheet.model.User;
@WebServlet("/login")

/**
 * Servlet implementation class Loginservlet
 */
public class Loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Loginservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		PrintWriter out=response.getWriter();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		UserDAOimpl userdao=new UserDAOimpl();
		AdminDAOimpl admindao=new AdminDAOimpl();
		User validuser=userdao.validateUser(username, password);
		User validadmin=admindao.validateAdmin(username, password);
		if(validuser!=null)
		{
			out.println("Login as "+validuser.getFirstname());
		RequestDispatcher reqdis=request.getRequestDispatcher("index.jsp");
		reqdis.forward(request, response);
		}
		else if(validadmin!=null)
		{
		  out.println("Login as "+validadmin.getFirstname()+" Admin");
		    RequestDispatcher reqdis=request.getRequestDispatcher("adminindex.jsp");
			reqdis.forward(request, response);
		}
		else
		{
		 out.println("invalid username");	
		}
		
	}

}