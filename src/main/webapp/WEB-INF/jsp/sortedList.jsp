<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>First Web Application</title>
</head>

<body>
	<tr>
		<td style="color:#0000FF"><h3>Sorted numbers in Ascending order:</h3> ${sortedNumbers}</td></tr><br><br>
		<tr><td style="color:#0000FF"><h3>Time Taken to Sort :</h3> ${timeTaken} MilliSeconds</td></tr><br><br>
		<tr><td style="color:#0000FF"><h3>Number of Changes Happened to Sort:</h3> ${noOfChanges}</td></tr><br><br>
	
	<tr><td>
	<a href="/login">Click here to try again!!</a> </td>
	</tr>
</body>

</html>