<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Start a game</title>
</head>
<body>
<form:form method="GET" commandName="hiddenData">
 <div class="pageTitle">Start a game</div>
   		
	    <table>
	        <tr>
	            <td><form:hidden path="start" value="start"/></td>
	        </tr>
	        <tr>
	            <td colspan="3">
	                <input type="submit" value="Start a game" />
	            </td>
	        </tr>
	    </table>
</form:form>
</body>
</html>