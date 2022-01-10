package com.timesheet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.timesheet.daoimpl.TaskDAOimpl;
import com.timesheet.daoimpl.TimesheetDAOimpl;
import com.timesheet.daoimpl.UserDAOimpl;
import com.timesheet.model.Timesheet;
@WebServlet("/timesheet")
/**
 * Servlet implementation class Timesheet
 */
public class Timesheetservlet extends HttpServlet {

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
		TimesheetDAOimpl timesheetdao=new TimesheetDAOimpl();
		DateTimeFormatter format=DateTimeFormatter.ofPattern("dd-MM-yyyy");
		int id=Integer.parseInt(request.getParameter("userid"));
		String timedate=request.getParameter("timesheetdate");
		LocalDate timesheetdate=LocalDate.parse(timedate);
		String taskname=request.getParameter("taskname");
		TaskDAOimpl taskdao=new TaskDAOimpl();
		int id1=taskdao.findtaskId(taskname);
		int spendinghrs=Integer.parseInt(request.getParameter("spendinghrs"));
		String comments=request.getParameter("comments");
		Timesheet timesheet=new Timesheet(id,id1,spendinghrs,comments,timesheetdate);
		boolean flag1 =timesheetdao.checkDate(id, timesheetdate);
		PrintWriter out=response.getWriter();
		if(flag1==false)
		{
		
		boolean flag=timesheetdao.insertTimesheet(timesheet);
		if(flag)
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Timesheet Added Successfully');");
			out.println("location='showtask.jsp';");
			out.println("</script>");
//			int taskid=taskdao.findtaskId(taskname);
//			request.setAttribute("taskid", taskid);
//			request.setAttribute("timesheet","Timesheet Added Successfully");
//			request.getRequestDispatcher("timesheetmain.jsp").forward(request, response);
//			request.setAttribute("taskname",taskname);
		}
		else
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Timesheet Not Added');");
			out.println("location='showtask.jsp';");
			out.println("</script>");
//			request.setAttribute("timesheet","Timesheet not Added");
//			request.getRequestDispatcher("timesheetmain.jsp").forward(request, response);
		}
		
	}
		else
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Timesheet already Exist');");
			out.println("location='viewalltimesheet.jsp';");
			out.println("</script>");
//			request.setAttribute("timesheet", "Timesheet already Exist");
//			request.getRequestDispatcher("timesheetmain.jsp").forward(request, response);
//		 	System.out.println("not available");
		}
	}
}
