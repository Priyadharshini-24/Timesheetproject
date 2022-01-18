<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update User</title>
<style>
  *
    {
    margin:0px;
    padding:0px;
    }
        a
        {
            
            margin-left: 30px;
        }
        .a
        {
            
            margin-left: 30px;
        }
        img
        {
         border-radius:45px;

        }
        body{
            background-size:cover;
        }
        h1{
            margin:0px;
            padding: 20px;
            background-color: rgb(127, 202, 231);
        }
        nav{
            background-color: rgb(127, 202, 231);
        }
       .signout
       {
           float : right;
           margin-right: 20px;
       }
       a:link {
        font-size: 20px;
        color: rgb(250, 252, 250);
        text-decoration: none;
          }
       a:hover {
         color: rgb(158, 250, 96);
         text-decoration: none;
         }
       a:active {
         color: rgb(245, 245, 91);
        text-decoration: underline;
        } 
        input
          {
            padding: 4px 15px;
            border-radius: 5px;
          }   
    </style>
     <link rel="stylesheet" href="addtaskmain.css">
</head>
<body style="background-image:url(images/Time2.jpg)">
 <h1 align="center">TRACK YOUR TIME</h1>
    <nav>
        
        <a href="adminindex.jsp"><img class="a" src="images/Home.jpg" alt="Home"width="42px" height="42px" title="Home"></a>
        <a href="timesheetstatus.jsp"><img src="images/timeshet.jpg" alt="Timesheet"width="42px" height="42px" title="Timesheet"></a>
        <a href="addtask.jsp"><img src="images/addtask.jpg" alt="addtask"width="42px" height="42px" title="Add Task"></a>
        <a href="#report.jsp"><img src="images/1report.jpg" alt="report"width="42px" height="42px" title="Report"></a>
        <a href="adminuser.jsp"><img src="images/user1.jpg" alt="user"width="42px" height="42px" title="user"></a>
        <a href="Logout"><img class="signout" src="images/signout.png" alt="signout"width="42px" height="42px" title="Signout"></a>
    </nav>
    <br><br>
    <div class="sidebar"> 
        <ul>
        <li><a href="showalluser.jsp">View Users</a><br><br></li>
        </ul>
    </div>
    <div class="box">
<% String username=(String)request.getParameter("username");%>
<form action="updateuseradmin" method="post">
<table cellspacing="15px">
<tr><th><label for="username">User Name</label></th>
<td><input type="text" name="username" value="<%=username%>" required readonly></td></tr>
<tr><th><label for="role">Role</label></th>
<td><select  name="role" required>
       <option>TEAM MEMBER</option>
       <option>IN ACTIVE</option>
       </select>
       </td></tr>
</table>
<br><br>
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
<input type="submit"value="Submit">
</form><br>
<%!
String flag;
%>
<%
if(request.getAttribute("updateuseradmin") != null){
flag = request.getAttribute("updateuseradmin").toString();
%>
<h4><%= flag%></h4>
<% }%> 
</div>
</body>
</html>