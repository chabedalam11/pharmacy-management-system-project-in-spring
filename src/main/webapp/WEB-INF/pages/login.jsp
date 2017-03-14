
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<style type="text/css">
</style>
	<head>
		<title>Login Page</title>
		
		<link rel="stylesheet" href="resources/css/style.css">
		<link rel="stylesheet" href="resources/css/bootstrap.css">
		<script src="resources/js/bootstrap.js"></script>
		<script src="resources/js/jquery.js"></script>
		<script src="resources/js/formValidation.js"></script>
		
	</head>
<body onload='document.loginForm.j_username.focus();'>


	<%
		String errorString = (String) request.getAttribute("error");
		if (errorString != null && errorString.trim().equals("true")) {
	%>
		<div class="row" style="margin-top: 10px">
			<div class="alert alert-danger col-md-4 col-md-offset-4">
				<span id="loginMsg">Sorry !! Wrong user name or password</span>
			</div>
		</div>
	<%
		}
	%>

	<%-- <c:set var="m" value=""></c:set> --%>
	
	<c:if test="${not empty msg}">
		<div class="row" style="margin-top: 10px">
			<div class="alert alert-success col-md-4 col-md-offset-4">
				<span id="loginMsg">${msg}</span>
			</div>
		</div>
	</c:if>
	
		




	<div class="login-wrap" style="margin-top: 20px">
		<div class="login-html">
			<input id="tab-1" type="radio" name="tab" class="sign-in" checked><label
				for="tab-1" class="tab">Sign In</label> <input id="tab-2"
				type="radio" name="tab" class="sign-up"><label for="tab-2"
				class="tab">Sign Up</label>
			<div class="login-form">
			
				<!-- sign in part -->
				<div class="sign-in-htm">
					<form name='loginForm' action="<c:url value='login' />"
						" method='POST'>
						<div class="group">
							<label for="user" class="label">Username</label> 
							<input id="loginuser" type="text" name='username' class="input">
						</div>
						<div class="group">
							<label for="pass" class="label">Password</label> 
							<input id="loginpass" type="password" name='password' class="input"	data-type="password">
						</div>

						<div class="group">
							<input type="submit" class="button" value="Sign In">
						</div>
					</form>
					<div class="hr"></div>
					
				</div>
				<!-- //sign in part -->
				
				<!-- sign up part -->
				<div class="sign-up-htm">
				
					<form action="signUP" method="post">
					
						<div class="group">
							<label for="user" class="label">Username</label> 
							<input id="user" type="text" name="username" class="input" required="required">
						</div>
						<div class="group">
							<label for="pass" class="label">Password</label> 
							<input id="txtNewPassword" type="password" name="password" class="input" data-type="password" required="required">
						</div>
						<input type="hidden" name="enabled" value="1">
						<div class="group">
							<label for="pass" class="label">Repeat Password</label> 
							<input	id="txtConfirmPassword" onkeyup="checkPass(); return false;" type="password" class="input" data-type="password" required="required">
							<span id="confirmMessage" class="confirmMessage"></span>
						</div>
						<div class="group">
							<label for="pass" class="label">Confirm Id</label> 
							<input	id="comId" type="text" class="input" required="required">
							
							<div style="margin-top: 10px;" class="alert alert-warning" id = "confirmIdMsg">
							  
							</div>
						</div>
						<div class="group">
							<input type="submit" class="button" value="Sign Up" id="submit" disabled>
						</div>
						<div class="hr"></div>
						<div class="foot-lnk">
							<label for="tab-1">Already Member?</label>
						</div>
					
					</form>
						
				</div>
				<!-- //sign up part -->
				
			</div>
		</div>
	</div>
	

</body>
</html>
