<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="/css/bootstrap.min.css" rel="stylesheet" />

<title>Insert title here</title>
</head>
<body>
	<div class="container-fluid">
		
			<form:form name="loginForm"  commandName="credentials" action="welcome" class="form-horizontal" method="post">
	
  <table>
  <br><br>
			<tr>
				<td><form:label path="username">Name</form:label></td>
				<td><form:input path="username" /></td>
			</tr>
			
			<tr></tr>
			<tr>
				<td><form:label path="password">Password</form:label></td>
				<td><form:input path="password" /></td>
			</tr>
		
			<tr>
				<td><input type="submit" class="btn btn-success " value="LOGIN" /></td>
			</tr>
		</table>
				
			</form:form>
		
	</div>
</body>
</html>