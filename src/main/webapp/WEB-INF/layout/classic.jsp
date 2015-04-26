<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>

<head>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name="title"></tiles:getAsString></title>
</head>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<body>


	<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
	
	<tilesx:useAttribute name="current"/>
	
	<div class="container">
	
		<nav class="navbar navbar-default">
		  <div class="container-fluid">
		    <!-- Brand and toggle get grouped for better mobile display -->
		    <div class="navbar-header">
		      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
		        <span class="sr-only">Toggle navigation</span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		      </button>
		      <a class="navbar-brand" href='<spring:url value="/"/>'>SzaSza JBA</a>
		    </div>
		
		    <!-- Collect the nav links, forms, and other content for toggling -->
		    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		      <ul class="nav navbar-nav">
		        <li class="${ current == 'index'? 'active' : '' }"><a href='<spring:url value="/"/>'>Home <span class="sr-only">( current )</span></a></li>
		        <li class="${ current == 'users'? 'active' : '' }"><a href='<spring:url value="/users.html"/>'>Users</a></li>
		        <li class="${ current == 'register'? 'active' : '' }"><a href='<spring:url value="/register.html"/>'>Registration</a></li>
		        <li class="${ current == 'login'? 'active' : '' }"><a href='<spring:url value="/login.html"/>'>Login</a></li>
		        <li> <a href='<spring:url value="/logout"/>'>Logout</a></li>
		      </ul>
		    </div><!-- /.navbar-collapse -->
		  </div><!-- /.container-fluid -->
		</nav>
		<tiles:insertAttribute name="body"/>
		
		<br><br>
		<center>
			<tiles:insertAttribute name="footer"/>
		</center>
	</div>
</body>
</html>