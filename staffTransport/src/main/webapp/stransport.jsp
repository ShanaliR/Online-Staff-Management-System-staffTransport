<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

	<meta charset="ISO-8859-1">
	<title>Transport Seat Booking</title>
	<style type="text/css">
		body{
		font-family: Roboto, sans-serif;
		background-color: #f5f5f5;
		font-size: 16px;
		}
		.st{
		width:620px;
		height:200px;
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
		label{
		font-family:Roboto, sans-serif;
		font-size:24px;
		font-weight:500;
		
		}
		h1{
		font-family:Roboto, sans-serif;
		font-size: 50px;
		padding-top:15px;
		text-align: center;
		
		}
		.submit{
		font-family: Roboto, sans-serif;
		color: white;
  		background-color: #3273dc;
  		border-radius: 4px;
  		box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
		}
		.box{
		box-sizing: border-box;
 		width: 100%;
  		border:3px solid darkgray;
  		background-color: #fff;
  		border-radius: 4px;
  		background-position: 10px 12px;
  		font-size: 14px;
  		padding: 8px 8px 8px 8px;
  		border-radius: 4px;
  		box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
	
		}
		table {
  		width: 100%;
  		margin: 0 auto;
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

	<h1>Transport Service Seat Booking</h1>
	<br><br><br>
	<div class="st"> 
	
	<form action="transport" method="post">
	<br>
	<table>
	
		<tr>
			<td><label for="name">Name : </label></td>
			<td><input type="text" name="name" class="box" placeholder="Enter your name" required><br></td>
		</tr>
		<tr>
			<td><label for="email">Email : </label></td>
			<td><input type="text" name="email" class="box" placeholder="Enter your email" required><br></td>
		</tr>
		
	</table>
	
	<br>
		
		<input type="submit" name="submit" class="submit" value="Submit">
		
	</form>
	</div>
	
</body>
</html>