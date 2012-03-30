<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Time Slots List</title>
</head>
<body>
	<form:form method="GET" modelAttribute="timeSlots">

<div class="pageTitle">Time Slots List</div>
<br>
 <c:if test="${!empty timeSlots}" > 
 <table class="altrowstable">
	 <tr>
	   <th>Id</th>
	   <th>Serial Number</th>
	   <th>Enabled</th>
	   <th>Start Instant</th>
	   <th>End Instant</th>
	 </tr>
	  <c:forEach items="${timeSlots}" var="ts">
		  <tr>
		  	   <td>
		      	<c:out value="${ts.id}"/><br><br>
		      </td>
		   	  <td>
		      	<c:out value="${ts.serialNumber}"/><br><br>
		      </td>
		      <td>
		      	<c:out value="${ts.enabled}"/><br><br>
		      </td>
		       <td>
		      	<c:out value="${ts.startInstant}"/><br><br>
		      </td>
		       <td>
		      	<c:out value="${ts.endInstant}"/><br><br>
		      </td>
		  </tr>
	  </c:forEach>
 </table>
 </c:if>  
 
 <c:if test="${empty timeSlots}">
   <h3>No time slots are available.</h3> 
</c:if> 
    <!-- <input type="hidden" id="items[0].name" name="items[0].name" value="foo"/> -->
  <br><br>  
    <table>
      <tr>
      	<td><input type="submit" value="Add Customer">
      </tr>
    </table>

</form:form>
</body>
</html>