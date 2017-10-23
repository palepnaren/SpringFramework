<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

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
