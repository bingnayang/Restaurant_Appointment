<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Appointment List</h1>
	<table>
		<tr>
			<th>Date</th>
			<th>Time</th>
			<th>Name</th>
			<th>Number of People</th>
			<th>Phone</th>
			<th>Note</th>
		</tr>
		<c:forEach items="${list}" var="allAppointmentList">
			<tr>
				<td>${allAppointmentList.appt_Date}</td>
				<td>${allAppointmentList.appt_Time}</td>				
				<td>${allAppointmentList.name}</td>
				<td>${allAppointmentList.numb_People}</td>				
				<td>${allAppointmentList.phone}</td>		
				<td>${allAppointmentList.note}</td>							
			</tr>
		</c:forEach>
	</table>
</body>
</html>