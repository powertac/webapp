<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tariff List</title>
</head>
<body>
<form:form method="GET"  modelAttribute="tariffs">

<div class="pageTitle">Tariff List</div>
<br>
 <c:if test="${!empty tariffs}" > 
 <table class="altrowstable">
	 <tr>
	   <th>specId</th>
	   <th>Broker</th>
	   <!--  <th>Customer Type</th> -->
	   <th>Expiration</th>
	   <th>State</th>
	   <th>Is Superseded By</th>
	 </tr>
	  <c:forEach items="${tariffs}" var="tariff">
		  <tr>
		  	   <td>
		      	<c:out value="${tariff.specId}"/><br><br>
		      </td>
		   	  <td>
		      	<c:out value="${tariff.broker}"/><br><br>
		      </td>
		       <td>
		      	<c:out value="${tariff.expiration}"/><br><br>
		      </td>
		       <td>
		      	<c:out value="${tariff.state}"/><br><br>
		      </td>
		       <td>
		      	<c:out value="${tariff.isSupersededBy}"/><br><br>
		      </td>
		  </tr>
	  </c:forEach>
 </table>
 </c:if>  
 
 <c:if test="${empty tariffs}">
   <h3>There are currently no tariffs.</h3> 
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