<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Task</title>
    <style>
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
       /* a:link {
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
        }    */
    </style>
    <link rel="stylesheet" href="addtaskmain.css">
</head>
<body style="background-image:url(images/Time2.jpg)";>
 
    <h1 align="center">TRACK YOUR TIME</h1>
    <nav>
        
        <a href="adminindex.jsp"><img class="a" src="images/Home.jpg" alt="Home"width="42px" height="42px" title="Home"></a>
        <a href="#timesheet.jsp"><img src="images/timeshet.jpg" alt="Timesheet"width="42px" height="42px" title="Timesheet"></a>
        <a href="addtask.jsp"><img src="images/addtask.jpg" alt="addtask"width="42px" height="42px" title="Add Task"></a>
        <a href="#report.jsp"><img src="images/1report.jpg" alt="report"width="42px" height="42px" title="Report"></a>
        <a href="showalluser.jsp"><img src="images/user1.jpg" alt="user"width="42px" height="42px" title="user"></a>
        <a href="login.jsp"><img class="signout" src="images/signout.png" alt="signout"width="42px" height="42px" title="Signout"></a>
    </nav><br><br>
    <div class="sidebar">
        <ul>
        <li><a href="addtaskmain.jsp">Add Task</a><br><br></li>
         <li><a href="showalltask.jsp">View Task</a><br><br></li>
          <li><a href="updatetask.jsp">Edit Task</a><br><br></li>
        </ul>
    </div>
    <div class="box">
        <form method="post" action="addtask">
            <table>
             <tr>
       <th><label for="taskname">Enter Task Name</label></th>
       <td><input type="text" name="taskname"  required></td>
    </tr>
    <tr>
       <th> <label for="assigningdate">Enter Task Assigning Date</label></th>
        <td><input type="date" name="assigningdate" required></td>
    </tr>
    <tr>
       <th><label for="endingdate">Enter Task Ending Date</label></th>
       <td><input type="date" name="endingdate" required></td>
    </tr>
     <tr>
       <th><label for="priority">Enter Task Priority</label></th>
       <td><select  name="priority" required>
       <option>Low</option>
       <option>Medium</option>
       <option>High</option>
       </select>
       </td>
    </tr>
     <tr>
       <th><label for="assignedto">Task Assigned To</label></th>
       <td><input type="email" name="username" required></td>
    </tr>
    </table><br><br>
   &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <input type="submit"value="Submit">
   &nbsp; &nbsp; <input type="reset"value="Clear">
    </form> 
    <%!
String flag;
%>
<%
if(request.getAttribute("task") != null){
flag = request.getAttribute("task").toString();
%>
<h4><%= flag%></h4>
<% }%> 
    </div>
</body>
</html>