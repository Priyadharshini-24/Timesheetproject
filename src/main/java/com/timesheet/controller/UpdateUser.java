package com.timesheet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.timesheet.daoimpl.UserDAOimpl;
import com.timesheet.model.User;
@WebServlet("/updateuser")

public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UpdateUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		UserDAOimpl userdao=new UserDAOimpl();
		User user=new User(firstname,lastname,username,password);
		boolean flag=userdao.updateUser(user);
		if(flag)
		{
			request.setAttribute("updateuser","User Details Updated Successfully");
		}
		else
		{
			request.setAttribute("updateuser","User Details not Updated ");
		}
		request.getRequestDispatcher("showuser.jsp").forward(request, response);
	}

}
