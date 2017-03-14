<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Hello Admin</title>
		<!-- Bootstrap Core CSS -->
		    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
		
		    <!-- Custom CSS -->
		    <link href="resources/css/sb-admin.css" rel="stylesheet">
		
		    <!-- Morris Charts CSS -->
		    <link href="resources/css/plugins/morris.css" rel="stylesheet">
		
		    <!-- Custom Fonts -->
		    <link href="resources/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
		
		   
</head>

<body>
	
	<!-- <a href="adminp2.html">go</a> -->
	<c:url value="/j_spring_security_logout" var="logoutUrl" scope="session"/>
	
	
	
	
	    <div id="wrapper">