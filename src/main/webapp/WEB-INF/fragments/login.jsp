<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page isELIgnored="false" %>
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


	
	<h3>Login with Username and Password</h3>
	
	<c:if test="${param.error !=null}">
		<span id="login-error">Login failed!!.Username or Password Incorrect...</span>
	</c:if>
	
	<form name='f' action='${pageContext.request.contextPath}/j_spring_security_check' method='POST' id="list">
		<table id="form-table">
			<tr>
				<td>User:</td>
				<td><input id="text" type='text' name='j_username' value=''></td>
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
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$('#text').focus();
		});
	</script>

