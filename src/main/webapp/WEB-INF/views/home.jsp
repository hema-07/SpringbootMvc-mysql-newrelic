<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%


    if (session.getAttribute("username") == null) {
        response.sendRedirect("/");
    }
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>welcome</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style>
.navbar {
    overflow: hidden;
    background-color: #333;

}

.navbar a {
    float: left;
    font-size: 16px;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

.dropdown {
    float: left;
    overflow: hidden;
}

.dropdown .dropbtn {
    font-size: 16px;
    border: none;
    outline: none;
    color: white;
    padding: 14px 16px;
    background-color: inherit;
}



.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}

.dropdown-content a {
    float: none;
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
    text-align: left;
}
.navbar a:hover, .dropdown:hover .dropbtn {
    background-color: light grey;

}

.dropdown-content a:hover {
    background-color: #ddd;

}
.dropdown:hover .dropdown-content {
    display: block;
}
</style>
</head>

<body>
<h1 style="text-align: center;">Movie Library </h1><br>
<div class="navbar">
  <a href="/home"><span class="glyphicon glyphicon-home"></span> Home</a>
  <div class="dropdown">
    <button class="dropbtn">Movie
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
     <a href="/filmindex"><span class="glyphicon glyphicon-list"></span>&nbsp; Movie List</a>
     <a href="/filmnew"><span class="glyphicon glyphicon-plus"></span>&nbsp; ADD Movie</a>
    </div>
  </div>

   <div class="dropdown">
      <button class="dropbtn">Music
        <i class="fa fa-caret-down"></i>
      </button>
      <div class="dropdown-content">
        <a href="/musicindex"><span class="glyphicon glyphicon-list"></span>&nbsp; Music List</a>
         <a href="/musicnew"><span class="glyphicon glyphicon-plus"></span>&nbsp; ADD Music</a>
      </div>
    </div>

       <div class="dropdown" style="float:right;">
                <a href="/logout">Logout<span class="glyphicon glyphicon-log-out"></span></a>
          </div>

</div>

<div class="container" style="text-align:center">

    <h1><b>Welcome to Movie Library</b></h1>
    <h3><p>It's about Movie and Music list. You can add, update, remove Movies, music from this list.</p>
    <p>Movie and Music Zone</p></h3>
</div>

</div>
</body>
</html>