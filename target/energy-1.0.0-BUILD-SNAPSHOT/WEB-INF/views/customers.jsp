<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer List</title>
</head>
<body>
<form:form method="GET"  modelAttribute="customers">

<div class="pageTitle">Customers List</div>
<br>
 <c:if test="${!empty customers}" > 
 <table class="altrowstable">
	 <tr>
	   <th>Id</th>
	   <th>Name</th>
	   <!--  <th>Customer Type</th> -->
	   <th>Multi Contracting</th>
	   <th>Can Negotiate</th>
	   <th>Population</th>
	 </tr>
	  <c:forEach items="${customers}" var="cust">
		  <tr>
		  	   <td>
		      	<c:out value="${cust.id}"/><br><br>
		      </td>
		   	  <td>
		      	<c:out value="${cust.name}"/><br><br>
		      </td>
		       <td>
		      	<c:out value="${cust.multiContracting}"/><br><br>
		      </td>
		       <td>
		      	<c:out value="${cust.canNegotiate}"/><br><br>
		      </td>
		       <td>
		      	<c:out value="${cust.population}"/><br><br>
		      </td>
		  </tr>
	  </c:forEach>
 </table>
 </c:if>  
 
 <c:if test="${empty customers}">
   <h3>There are currently no customers.</h3> 
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