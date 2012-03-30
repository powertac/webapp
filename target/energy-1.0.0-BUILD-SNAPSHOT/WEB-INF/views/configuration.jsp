<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel='stylesheet' type='text/css' href='../themes/energytac.css'>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="http://cdn.jquerytools.org/1.2.6/jquery.tools.min.js"></script>
<script type="text/javascript">                                         
		$("ul.tabs").tabs("div.panes > div");                                    
</script> 
</head>
<body>
<form:form method="POST" action="save" modelAttribute="configuration">
<div class="pageTitle">EnergyTac Configuration</div></<br>

<div>

<br/><br/>

    <c:if test="${!empty configuration}">
    
    <table background="white" width="400px" border="0">
		<!--  <tr><td><label>Time Base</label></td><td><input value="${configuration.baseTime}"/></td></tr>-->
		<tr>
		  <td>Time Base</td>
		  <td><form:input path="baseTime" /></td>
		  <td width="200px"><div class="error"></div><form:errors path="baseTime" cssClass="error" /></div></td>
		</tr>
		<tr><td><label>MinimumTimeslotCount</label></td><td><form:input path="minimumTimeslotCount"/></td></tr>
		<tr><td><label>ExpectedTimeSlot</label></td><td><form:input path="expectedTimeSlot"/></td></tr>
		<tr><td><label>TimeslotLength</label></td><td><form:input path="timeslotLength"/></td><tr>
		<tr><td><label>competition.simulationTimeslotSeconds</label></td><td><form:input path="simulationTimeslotSeconds"/></td></tr>
		<tr><td><label>competition.bootstrapTimeslotSeconds</label></td><td><form:input path="bootstrapTimeslotSeconds"/></td></tr>
		<tr><td><label>competition.timeslotsOpen</label></td><td><form:input path="timeslotsOpen"/></td></tr>
		<tr><td><label>competition.deactivateTimeslotsAhead</label></td><td><form:input path="deactivateTimeslotsAhead"/></td></tr>
		<tr><td><label>competition.bootstrapTimeslotCount</label></td><td><form:input path="bootstrapTimeslotCount"/></td></tr>
		<tr><td><label>accounting.interest</label></td><td><form:input path="interest"/></td></tr>
		<tr><td><label>tariffMarket.publicationFee</label></td><td><form:input path="publicationFee"/></td></tr>
		<tr><td><label>tariffMarket.publicationInterval</label></td><td><form:input path="publicationInterval"/></td></tr>
		<tr><td><label>tariffMarket.publicationOffset</label></td><td><form:input path="publicationOffset"/></td></tr>
		<tr><td><label>auctioneer.sellerSurplus</label></td><td><form:input path="sellerSurplus"/></td></tr>
		<tr><td><label>auctioneer.defaultMargin</label></td><td><form:input path="defaultMargin"/></td></tr>
		<tr><td><label></label></td><td></td></tr>
		<tr><td><label></label></td><td></td></tr>
		<tr><td><label></label></td><td></td></tr>
		<tr><td><label></label></td><td></td></tr>
		<tr><td><label></label></td><td></td></tr>
		<tr><td><label></label></td><td></td></tr>
		<tr><td><label></label></td><td></td></tr>
	</table> 
     
    
    </c:if>
     <c:if test="${empty configuration}">
     	<h1>The configuration is empty</h1>
     </c:if>
     
     <br>
      <div>
	    <table>
	        <tr>
	            <td colspan="3" width="50px">
	                <input type="submit" value="Save" name="save" />
	            </td>
	        </tr>
	    </table>
	 </div>
  </form:form>



		<!--<c:if test="${!empty configurations}">
			<table class="table" border="1">
				<c:forEach var="config" items="${configurations}">
					<tr>
						<td><cut value="${config}" /></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<c:if test="${empty inventories}">
    There are currently no inventories.
</c:if> -->


</div>
<!-- the tabs 
<ul class="tabs">
	<li><a href="#">Tab 1</a></li>
	<li><a href="#">Tab 2</a></li>
	<li><a href="#">Tab 3</a></li>
</ul>
 
<div class="panes">
	<div>pane 1 content</div>
	<div>pane 2 content</div>
	<div>pane 3 content</div>
</div>-->
</body>
</html>