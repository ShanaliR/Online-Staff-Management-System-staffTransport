<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Transportation Account</title>
	
	<style type="text/css">
		h1{
		font-family:Roboto, sans-serif;
		font-size: 50px;
		padding-top:15px;
		text-align: center;
		}
		.st{
		width:600px;
		height:410px;
		margin:auto;
		background-color:#adebe9;
		box-shadow: 0px 0px 15px currentcolor;
    	border: 5px solid currentcolor;
		border-radius:3px;
		top: 50%;
    	left: 50%;
    	text-align: center;
    	padding: 20px;
		}
		table {
  		width: 100%;
  		margin: 0 auto;
		}
		th,td{
		border:3px solid black;
		}
		.submit{
		font-family: Roboto, sans-serif;
		color: white;
  		background-color: #3273dc;
  		border-radius: 4px;
  		box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
		}
		tr {
  		display: flex;
  		justify-content: space-between;
  		align-items: center;
  		margin: 10px 0;
		}
		td {
  		width: 50%;
  		padding: 5px;
		}
		.box, .submit {
  		transform: scale(1);
 		transition: transform 0.25s ease-in-out;
		}
		.box:focus, .submit:hover {
  		transform: scale(1.1);
		}
	
	</style>
</head>
<body>

	<h1>Transport Service Account Details</h1>
	<br><br><br>
	<div class="st"> 
	<br>
	<table>
	
	<c:forEach var="tr" items="${trDetails}">
	
	<c:set var="id" value="${tr.id}"/>
	<c:set var="name" value="${tr.name}"/>
	<c:set var="email" value="${tr.email}"/>
	<c:set var="phone" value="${tr.phone}"/>
	<c:set var="address" value="${tr.address}"/>
	<c:set var="distance" value="${tr.distance}"/>
	
	<tr>
		<td>Booking ID</td>
		<td>${tr.id}</td>
	</tr>
	
	<tr>
		<td>Employee Name</td>
		<td>${tr.name}</td>
	</tr>
	
	<tr>
		<td>Employee Email</td>
		<td>${tr.email}</td>
	</tr>
	
	<tr>
		<td>Employee Phone</td>
		<td>${tr.phone}</td>
	</tr>
	
	<tr>
		<td>Employee Address</td>
		<td>${tr.address}</td>
	</tr>
	
	<tr>
		<td>Employee Distance</td>
		<td>${tr.distance}</td>
	</tr>
	
	</c:forEach>
	</table>
	
	
	<c:url value="updateTransport.jsp" var="transupdate">
		<c:param name="id" value="${id}"/>
		<c:param name="name" value="${name}"/>
		<c:param name="email" value="${email}"/>
		<c:param name="phone" value="${phone}"/>
		<c:param name="address" value="${address}"/>
		<c:param name="distance" value="${distance}"/>
	</c:url>
	
	<br><br>
	
	<a href="${transupdate}">
	<input type="button" name="update" class="submit" value="Update">
	</a>
	
	<br><br>
	
	<c:url value="deletetransport.jsp" var="transdelete">
		<c:param name="id" value="${id}"/>
		<c:param name="name" value="${name}"/>
		<c:param name="email" value="${email}"/>
		<c:param name="phone" value="${phone}"/>
		<c:param name="address" value="${address}"/>
		<c:param name="distance" value="${distance}"/>
	</c:url>
	
	<a href="${transdelete}">
	<input type="button" name="delete" class="submit" value="Delete My Account">
	</a>
	</div>
</body>
</html>