<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
 <link rel='stylesheet' type='text/css' href='../themes/energytac.css'> 
<!-- <link rel='stylesheet' type='text/css' href='../CSS/energytac.css'> -->

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Broker List</title>
</head>
<body>
<form:form method="GET"  modelAttribute="brokers">

<div class="pageTitle">Broker List</div>
<br>
 <c:if test="${!empty brokers}" > 
 <table class="altrowstable">
	 <tr>
	   <th>Id</th>
	   <th>User Name</th>
	   <th>Cash Position</th>
	   <th>Enabled</th>
	   <th>Account Expired</th>
	 </tr>
	  <c:forEach items="${brokers}" var="broker">
		  <tr>
		   	  <td>
		      	<c:out value="${broker.id}"/><br>
		      </td>
				   	  <td>
		      	<c:out value="${broker.username}"/><br>
		      </td>
		 	    <td>
		      
		      </td>
		 	  
		   	  <td>
		      	<c:out value="${broker.enabled}"/><br>
		      </td>
		   	  <td>
		      
		      </td>
		  </tr>
	  </c:forEach>
    
 </table>
 </c:if>  
 
 <c:if test="${empty brokers}">
   <h3>There are currently no brokers registered.</h3> 
</c:if> 
    <!-- <input type="hidden" id="items[0].name" name="items[0].name" value="foo"/> -->
  <br><br>  
    <table>
      <tr>
      	<td><input type="submit" value="Add a Broker">
      	<!--  <td><input type="submit" value="Cancel"> -->
      </tr>
    </table>

</form:form>
</body>
</html>