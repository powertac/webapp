<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order Book List</title>
</head>
<body>
<form:form method="GET" modelAttribute="orderBooks">

<div class="pageTitle">Order Book List</div>
<br>
 <c:if test="${!empty orderBooks}" > 
 <table class="altrowstable">
	 <tr>
	   <th>Id</th>
	   <th>Date Executed</th>
	   <!--  <th>Customer Type</th> -->
	   <th>Transaction Id</th>
	   <th>Product</th>
	   <th>Timeslot</th>
	   <th>Clearing Price</th>
	 </tr>
	  <c:forEach items="${orderBooks}" var="ob">
		  <tr>
		  	   <td>
		      	<c:out value="${ob.id}"/><br><br>
		      </td>
		   	  <td>
		      	<c:out value="${ob.dateExecuted}"/><br><br>
		      </td>
		       <td>
		      	
		      </td>
		       <td>
		      
		      </td>
		      <td>
		      	<c:out value="${ob.timeslot}"/><br><br>
		      </td>
		       <td>
		      	<c:out value="${ob.clearingPrice}"/><br><br>
		      </td>
		  </tr>
	  </c:forEach>
 </table>
 </c:if>  
 
 <c:if test="${empty orderBooks}">
   <h3>No order books are available.</h3> 
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