<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<h2>This page is for Administrator only!!</h2>
<table id="list">
	<thead>
	<tr><th>Username</th><th>Enable</th><th>Authority</th></tr>
	</thead>
	<c:forEach var="row" items="${user}">
	<tbody>
	<tr><td>${row.username}</td><td>${row.enable}</td><td>${row.authorization}</td></tr>
	</tbody>
	</c:forEach>
</table>
