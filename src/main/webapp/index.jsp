
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HelloWorld</title>

<link rel='stylesheet prefetch' href='http://fonts.googleapis.com/css?family=Open+Sans:600'>

      <link rel="stylesheet" href="resources/css/style.css">
      

</head>
<body>

<!-- redirect page that goes to admin page -->

<c:redirect url="admin.html"/>

<c:out value="hello"></c:out>
<a href="https://blackrockdigital.github.io/startbootstrap-sb-admin/">Dashboard url</a>


</body>
</html>

