<%-- <% response.sendRedirect("AppointmentController?action=LIST");%> --%>
<!DOCTYPE>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<title>Restaurant Appointment</title>
</head>
<body class="text-center">
<%
	String email = (String)session.getAttribute("email");
	// If user is already logged in, redirect to list page
	if(email != null){
		response.sendRedirect("AppointmentController?action=LIST");
	}

	String status = request.getParameter("status");

	if(status != null){
		if(status.equals("false")){
			out.print("Bad Credentials");
		}else if(status.equals("error")){
			out.print("Error Occured");
		}
	}
	
%>

	<form class="form-signin" action="loginprocess" method="POST">
		<img class="mb-4"
			src="https://image.flaticon.com/icons/svg/685/685352.svg" alt=""
			width="72" height="72">
		<h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
		<label for="inputEmail" class="sr-only">Email address</label> 
		<input type="email" id="inputEmail" class="form-control" placeholder="Email address" name="email" required> 
		<label for="inputPassword" class="sr-only">Password</label> 
		<input type="password" id="inputPassword" class="form-control"
			placeholder="Password" name="password" required>
		<div class="checkbox mb-3">
			<label> 
				<input type="checkbox" value="remember-me"> Remember me
			</label>
		</div>
		<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
	</form>

<style>
html, body {
	height: 100%;
}

body {
	display: -ms-flexbox;
	display: flex;
 	-ms-flex-align: center;
	align-items: center;
	padding-top: 30px;
	padding-bottom: 40px;
	background-color: #f5f5f5;
}

.form-signin {
	width: 100%;
	max-width: 330px;
	padding: 15px;
	margin: auto;
}

.form-signin .checkbox {
	font-weight: 400;
}

.form-signin .form-control {
	position: relative;
	box-sizing: border-box;
	height: auto;
	padding: 10px;
	font-size: 16px;
}

.form-signin .form-control:focus {
	z-index: 2;
}

.form-signin input[type="email"] {
	margin-bottom: -1px;
	border-bottom-right-radius: 0;
	border-bottom-left-radius: 0;
}

.form-signin input[type="password"] {
	margin-bottom: 10px;
	border-top-left-radius: 0;
	border-top-right-radius: 0;
}
</style>
</body>
</html>