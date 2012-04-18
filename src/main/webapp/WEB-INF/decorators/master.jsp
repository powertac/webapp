<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<html>
  <head>
  	<link rel='stylesheet' type='text/css' href='../themes/energytac.css'>
    <title>
    	Power TAC server : <decorator:title /> 
    </title>
  </head>
  <body>
   <form:form method="GET">
    <div id="header" >
       <div><img src="../images/logos/tac_logo.png"></img></div><br>
       <div class="masterHeader">Welcome to Power TAC</div>
       
    </div>
    
    <div id="main">
    <table>
      <tr>
	      <td>
		    <div class="navMenu">
		    	 <table>
		    	 <tr><td>
				   <a href="/admin/view/startgame">Start a competition</a>
				 </td></tr>
				 <tr><td>
				   <a href="/admin/view/configuration">Configuration</a>
				 </td></tr>
				 <tr><td>
				   <a href="/admin/view/brokers">Brokers</a>
				</td></tr>
				 <tr><td>
				   <a href="/admin/view/customer">Customers</a>
				</td></tr>
				 <tr><td>
				   <a href="/admin/view/tariffs">Tariffs</a>
				 </td></tr>
				 <tr><td>
				   <a href="/admin/view/orderBooks">Order Books</a>
				 </td></tr>
				 <tr><td>
				   <a href="/admin/view/timeSlots">Time Slots</a>
				 </td></tr>
				 <tr><td>
				   <a href="#">Market Position</a>
				 </td></tr>
				 <tr><td>
				   <a href="#">Cash Position</a>
				 </td></tr>
				 <tr><td>
				   <a href="#">Bank Transaction</a>
				 </td></tr>
				 <tr><td>   
				   <a href="#">Balancing Transaction</a>
				 </td></tr>
				 <tr><td>
				   <a href="#">Weather</a>
				 </td></tr>
		         </table>
		    </div>
		   </td>
	    
			 <td>
			     <div class="masterContent">
			     	 <decorator:body />
			      </div>
			 </td>
	   </tr>
    </table>
    </div>
    <br><br><br><br>
    <div>
    	
    </div>
    </form:form>
  </body>
</html>
<!--  <html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

</body>
</html>-->