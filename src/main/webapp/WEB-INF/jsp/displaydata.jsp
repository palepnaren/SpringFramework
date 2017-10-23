<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/db/style/style.css">
<title>Display List</title>
</head>
<body>
<h2>Data Base results</h2>
	<table id="list">
	<thead>
	<tr><th>ID</th><th>Name</th><th>Gender</th><th>Color</th></tr>
	</thead>
	<c:forEach var="row" items="${data}">
	<tbody>
	<tr><td>${row.id}</td><td>${row.name}</td><td>${row.gender}</td><td>${row.fave_color}</td></tr>
	</tbody>
	</c:forEach>
	</table>
</body>
</html>