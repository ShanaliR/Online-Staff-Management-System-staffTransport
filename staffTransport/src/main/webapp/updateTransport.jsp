<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transport Account Update</title>
<style type="text/css">
		body{
		font-family: Roboto, sans-serif;
		background-color: #f5f5f5;
		font-size: 16px;
		}
		.st{
		width:700px;
		height:440px;
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
	
	<script type="text/javascript">
	
	function validateForm() {
        // JavaScript validation logic
        var nameInput = document.getElementsByName('name')[0].value;
        var emailInput = document.getElementsByName('email')[0].value;
        var phoneInput = document.getElementsByName('phone')[0].value;
        var addressInput = document.getElementsByName('address')[0].value;
        var distanceInput = document.getElementsByName('distance')[0].value;

        if (nameInput === '' || emailInput === '' || phoneInput === '' || addressInput === '' || distanceInput === '') {
            alert('All fields are required');
            return false;
        }
       
        
        var emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
        if (!emailPattern.test(emailInput)) {
            alert('Email is not in the correct format');
            return false;
        }
        return true;
	}

    </script>
	
</head>
<body>

	<%
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String address=request.getParameter("address");
		String distance=request.getParameter("distance");
	%>
	
	<h1>Employee Transport Account Update</h1>
	<br><br><br>
	<div class="st"> 
	
	<form action="update" method="post" onsubmit="return validateForm();">
	<br>
	<table>
	
		<tr>
			<td><label for="id">Booking ID : </label></td>
			<td><input type="text" name= "empid" class="box" id="id" value="<%= id %>" readonly><br></td>
		</tr>
		<tr>
			<td><label for="name">Employee Name : </label></td> 
			<td><input type="text" name= "name" class="box" id="name"value="<%= name %>"><br></td>
		</tr>
		<tr>
			<td><label for="email">Email : </label></td>
			<td><input type="text" name= "email" class="box" id="email" value="<%= email %>"><br></td>
		</tr>
		<tr>
			<td><label for="phone">Phone Number : </label></td>
			<td><input type="text" name= "phone" class="box" id="phone" value="<%= phone %>"><br></td>
		</tr>
		<tr>
			<td><label for="address">Address : </label></td>
			<td><input type="text" name= "address" class="box" id="address" value="<%= address %>"><br></td>
		</tr>
		<tr>
			<td><label for="distance">Distance : </label></td>
			<td><input type="text" name= "distance" class="box" value="<%= distance %>"><br></td>
		</tr>
				
	</table>
	
	<br>
		<input type="submit" name="submit" class="submit" value="Update">
	
	</form>
	</div>
</body>
</html>