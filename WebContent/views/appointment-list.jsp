<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Restaurant Appointment System</title>
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
		<button class="btn btn-outline-light my-2 my-sm-0" type="submit" onclick="window.location.href='views/appointment-add.jsp'">Book Appointment</button>
	</nav>

	<div class="container-fluid">
		<table class="table table-striped">
				<tr style="background-color: #1F3944; color: white;">
					<th>Date</th>
					<th>Time</th>
					<th>Name</th>
					<th>People</th>
					<th>Phone</th>
					<th>Note</th>
				</tr>
				<c:forEach items="${allAppointmentList}" var="appointmentList">
					<tr>
						<td>${appointmentList.appt_Date}</td>
						<td>${appointmentList.appt_Time}</td>
						<td>${appointmentList.name}</td>
						<td>${appointmentList.numb_People}</td>
						<td>${appointmentList.phone}</td>
						<td>${appointmentList.note}</td>
					</tr>
				</c:forEach>
		</table>
	</div>


	<!-- JS, Popper.js, and jQuery -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
		integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
		crossorigin="anonymous"></script>
</body>
</html>