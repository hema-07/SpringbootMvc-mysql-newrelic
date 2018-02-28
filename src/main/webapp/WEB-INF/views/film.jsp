<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%

    if (session.getAttribute("username") == null) {
        response.sendRedirect("/");
    }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit film</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<h1 style="text-align: center;">Welcome to Movie Library</h1><br>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">

    <ul class="nav navbar-nav">
  <li><a href="/home"><span class="glyphicon glyphicon-home"></span> Home</a></li>
  <li><a href="/filmindex">
      <span class="glyphicon glyphicon-list"></span>&nbsp; Movie List
</a></li>
  <li><a href="/filmnew">
      <span class="glyphicon glyphicon-plus"></span>&nbsp; ADD Movie
</a></li>
    </ul>
 <form action="/logout" method="get">

     <ul class="nav navbar-nav navbar-right">

      <li><button class="btn btn-lg" onclick="log()">Logout &nbsp; <span class="glyphicon glyphicon-log-out"></span></button></li>
    </ul>
 </form>
  </div>
</nav>
<div class="container">
  <div class="jumbotron">
    <h1>Movie</h1>
    <p>It's about movie list. You can add, update, remove movie from this list.</p>
    <p>All languages, budget, different kind of movies you can see</p>
  </div>
</div>
</body>
</html>