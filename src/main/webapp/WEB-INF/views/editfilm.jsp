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
<title>Edit Movie</title>
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
  <li><a href="/home"><span class="glyphicons glyphicons-arrow-left">&nbsp; Back</span></a></li>

    </ul>
    <form action="/logout" method="get">

        <ul class="nav navbar-nav navbar-right">

         <li><button class="btn btn-lg" onclick="log()">Logout &nbsp; <span class="glyphicon glyphicon-log-out"></span></button></li>
       </ul>
    </form>
  </div>
</nav>
<div class="container">
 <form action="/film/edit/update/${film.filmid}" method="post">
 <table class="table table-hover">
        <tr><td>Movie ID</td><td><input type="text" value="${film.filmid}" name="filmid" required pattern="[A-Za-z0-9]{4,10}"></td></tr>
       <tr><td>Movie name</td><td><input type="text" value="${film.filmname}" name="filmname" required pattern="[A-Za-z0-9]{4,20}"></td></tr>
       <tr><td>Movie Language</td><td><input type="text" value="${film.language}" name="language" required pattern="[A-Za-z]{4,}"></td></tr>
       <tr><td>Movie Budget</td><td><input type="text" value="${film.budget}" name="budget" required pattern="[0-9]{1,4}"></td></tr>
       <tr><td></td><td><button class="btn btn-lg btn-info" onclick="/film/edit/update/${film.filmid}"><span class="glyphicon glyphicon-floppy-save"></span>save</button></td></tr>
  </table>      
</form>
</div>
</body>
</html>