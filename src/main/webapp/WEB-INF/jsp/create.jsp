<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/db/style/style.css">
<title>Create Entry</title>
</head>
<body>

	<f:form method="post"  action="${pageContext.request.contextPath}/db/saved" commandName="dataTable" id="list">
	<table id="form-table">
		<tr><td>Name:</td><td><f:input type="text" name="name" path="name" placeholder="enter name"/><br><f:errors path="name" cssClass="error"></f:errors></td></tr>
		<tr><td>Gender:</td><td><f:input type="text" name="gender" path="gender" placeholder="enter M or F"/><br><f:errors path="gender" cssClass="error"></f:errors>
		</td></tr>
		<tr><td>Color:</td><td><f:input type="text" name="fave_color" path="fave_color" placeholder="enter fave_color"/><br>
		<f:errors path="fave_color" cssClass="error"></f:errors></td></tr>
		
		<tr><td><input type="submit" value="create"></td></tr>
	</table>
	</f:form>
	
	<a href='<c:url value="/j_spring_security_logout"/>'>logout!!</a>
</body>
</html>