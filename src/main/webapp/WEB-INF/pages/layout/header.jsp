<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Admin Pages</title>
		
		
		<!-- Bootstrap Core CSS -->
		     <link rel="stylesheet" href="resources/css/bootstrap.min.css">
			<link rel="stylesheet" href="resources/css/dataTables.bootstrap.min.css">
			
		    <!-- Custom CSS -->
		    <link href="resources/css/sb-admin.css" rel="stylesheet">
		
		    <!-- Morris Charts CSS -->
		    <link href="resources/css/plugins/morris.css" rel="stylesheet">
		
		    <!-- Custom Fonts -->
		    <link href="resources/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
		
		   
		    
		    <!-- js file -->
		    
		    <script type="text/javascript" src="resources/js/jquery-1.12.4.js"></script>
			<script type="text/javascript" src="resources/js/jquery.dataTables.min.js"></script>
			<script type="text/javascript" src="resources/js/dataTables.bootstrap.min.js"></script>

			<!-- //js file -->
			
			<!-- own js file -->
			
			<script type="text/javascript" src="resources/js/custom.js"></script>
			
			<!-- js file -->
			
			<script type="text/javascript">
				$(document).ready(function() {
				    $('#example').DataTable();
				} );
			</script>
		
</head>

<body>
	
	
	<c:url value="/j_spring_security_logout" var="logoutUrl" scope="session"/>
	
	
	
	
	    <div id="wrapper">