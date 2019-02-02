<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Backend Interface</title>
<style>

body {
 background-color:#ed8684;
 font-family: "Lucida Sans Unicode";
 }
</style>
</head>
<body>
<h1>This is the Backend Interface</h1>
<hr>
<form method="POST">
<table border="0">
<h4>Here you can define the start and end interval of elections.</h4>
<tr><td>Starting date: <input type="datetime-local" name="startdate"></td></tr><br>
<tr><td>Ending date: <input type="datetime-local" name="enddate"></td></tr>
<tr><td><a href='/operation'><input type="button" name="button" value="Set Date"></a></td></tr>
<tr><td><h4>Add candidates:</h4></td></tr>
<tr><td>First Name: <input type="text" name="firstname" placeholder="First name..."></td></tr>
<tr><td>Last Name: <input type="text" name="lastname" placeholder="Last name..."></td></tr>
<tr><td>Faculty: <input type="text" name="faculty" placeholder="Faculty..."></td></tr>
<tr><td><a href='/operation'><input type="button" name="button" value="Add Candidate" ></a></td></tr>
<tr><td><h4>Import E-mail:</h4><input type="text" name="emails" placeholder="Import email..."></td></tr>
<tr><td><a href="/operation"><input type="button" name="button" value="Import Email"></a></td></tr>
</table>
</form>
</body>
</html>