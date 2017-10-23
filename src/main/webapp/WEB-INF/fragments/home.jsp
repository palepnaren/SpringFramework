<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>


	
		<p><a href="${pageContext.request.contextPath}/db/list">Show
				data in table</a></p>
		<p><a href="${pageContext.request.contextPath}/db/create">create
				new entry</a></p>
		<p><a href="${pageContext.request.contextPath}/db/register">register
				account</a></p>
		

		<sec:authorize access="hasRole('admin')">
			<p><a href="<c:url value='/db/admin'/>">admin</a></p>
		</sec:authorize>
		
	

