<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DB Test</title>
</head>

<body>

	
		<p><a href="${pageContext.request.contextPath}/db/list">Show
				data in table</a></p>
		<p><a href="${pageContext.request.contextPath}/db/create">create
				new entry</a></p>
		<p><a href="${pageContext.request.contextPath}/db/register">register
				account</a></p>
		
		<sec:authorize access="!isAuthenticated()">
			<p><a href="<c:url value='/db/login'/>">log in</a></p>
		</sec:authorize>
		
		<sec:authorize access="isAuthenticated()">
			<p><a href="<c:url value='/j_spring_security_logout'/>">logout!!</a></p>
		</sec:authorize>

		<sec:authorize access="hasRole('admin')">
			<p><a href="<c:url value='/db/admin'/>">admin</a></p>
		</sec:authorize>
		
	

</body>
</html>