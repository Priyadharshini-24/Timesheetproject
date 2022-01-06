package com.timesheet.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.timesheet.dao.StatusDAO;
import com.timesheet.daoimpl.StatusDAOimpl;
import com.timesheet.daoimpl.TimesheetDAOimpl;
import com.timesheet.daoimpl.UserDAOimpl;
import com.timesheet.model.Status;
@WebServlet("/addstatus")

/**
 * Servlet implementation class Addstatus
 */
public class Addstatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addstatus() {
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
	  StatusDAOimpl statusdao=new StatusDAOimpl();
	  TimesheetDAOimpl timesheetdao=new TimesheetDAOimpl();
	  UserDAOimpl userdao=new UserDAOimpl();
	  String username=request.getParameter("username");
	  DateTimeFormatter format=DateTimeFormatter.ofPattern("dd-MM-yyyy");
	  String timedate=request.getParameter("timesheetdate");
	  LocalDate timesheetdate=LocalDate.parse(timedate);
	  String status=request.getParameter("status");
	  String approvedby=request.getParameter("approvedby");
      int id=userdao.findUserId(username);
      int id1=timesheetdao.findTimesheetId(timesheetdate);
		Status statusobj=new Status(id,id1,status,approvedby);
		boolean flag=statusdao.insertStatus(statusobj);
		if(flag)
		{
			request.setAttribute("status","status Added Successfully");
		}
		request.getRequestDispatcher("timesheetadmin.jsp").forward(request, response);
		
	}

}
