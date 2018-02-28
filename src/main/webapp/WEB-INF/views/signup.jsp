<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>signup</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style type="text/css">
  .container {
  margin-top: 50px;
  margin-left:500px;
  width: 500px;
  height: 500px;
  }
  </style>
</head>
<body>
<div class="container">
 <form action="/signup" method="post" style="padding-top: 20px;">
  <div class="table-responsive">
<h1> Movie Library</h1>
 
  <table class="table" style="display: block;">
  
  	<tr><td> <h1>Create an account </h1>
  	<br>
  	<p style="font-size:x-large;font-weight:bold; color: light blue;">UserName<br>
  	<input type="text" name="username" class="form-control input-lg" required pattern="[A-Za-z0-9]{4,10}">
  	
  	<p style="font-size:x-large;font-weight:bold;color: light blue;">Password<br>
  	<input type="password" name="password" class="form-control input-lg" required pattern="[A-Za-z0-9]{4,10}">
  	</td></tr>
  		
  		
  	<tr><td><button onclick="/signup" class="btn btn-lg btn-success"><span class="glyphicon glyphicon-user"></span> &nbsp;Sign Up</button></td></tr>
  </table>
  </div>
</form>
<hr>

 <a href="/" style="text-decoration:none;text-align: center;font-size:large;font-weight:bold;">Click Here to login </a>

</div>

</body>
</html>