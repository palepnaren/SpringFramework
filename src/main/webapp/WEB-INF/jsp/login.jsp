<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page isELIgnored="false" %>
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/db/style/style.css">
<title>Login Page</title>
</head>
<body onload='document.f.j_username.focus();'>
	<h3>Login with Username and Password</h3>
	
	<c:if test="${param.error !=null}">
		<span id="login-error">Login failed!!.Username or Password Incorrect...</span>
	</c:if>
	
	<form name='f' action='${pageContext.request.contextPath}/j_spring_security_check' method='POST' id="list">
		<table id="form-table">
			<tr>
				<td>User:</td>
				<td><input type='text' name='j_username' value=''></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='j_password' /></td>
			</tr>
			<tr>
				<td>Remember Me:</td>
				<td><input type='checkbox' name='_spring_security_remember_me' /></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit"
					value="Login" /></td>
			</tr>
		</table>
	</form>
	<p><a href="${pageContext.request.contextPath}/db/register">Click here to register!</a></p>
</body>
</html>
