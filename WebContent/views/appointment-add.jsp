<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Appointment</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	<nav class="navbar navbar-light mb-2" style="background-color: #1F3944;">
		<a class="navbar-brand text-white" href="#"> <i class="fa fa-cutlery"
			aria-hidden="true"></i> Restaurant Appointment
		</a>
		<button class="btn btn-outline-light my-2 my-sm-0" onclick="goBack();">Back To Appointment List</button>
	</nav>
	<div class="container p-3 mb-2 bg-light text-dark" style="margin-top: 2em;">
		<h2 class="text-center">Book Appointment</h2>
		<form action="${pageContext.request.contextPath}/AppointmentController" method="POST">
			<div class="form-group">
				<label for="date">Date</label> 
				<input type="date" class="form-control" name="date">
			</div>
			<div class="form-group">
				<label for="time">Time</label> 
				<input type="time" class="form-control" name="time">
			</div>
			<div class="form-group">
				<label for="name">Name</label> 
				<input type="text" class="form-control" name="name">
			</div>
			<div class="form-group">
				<label for="number">Number of People</label> 
				<input type="number" class="form-control" name="people">
			</div>
			<div class="form-group">
				<label for="phone">Phone</label> 
				<input type="tel" class="form-control" name="phone" pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}" placeholder="123-456-7890">
			</div>
			<div class="form-group">
				<label for="exampleFormControlTextarea1">Notes</label>
				<textarea class="form-control" rows="3" name="note"></textarea>
			</div>
			  <button type="submit" class="btn btn-secondary btn-lg btn-block" style="background-color: #1F3944;">Submit</button>
		</form>
	</div>
</body>
<script type="text/javascript">
	function goBack()
	{
		location.href="${pageContext.request.contextPath}/AppointmentController?action=LIST";
	}
</script>
</html>