<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
		uri="http://www.springframework.org/security/tags"%>
		
<a id="title" href="<c:url value='/db'/>">Home</a>	

<sec:authorize access="!isAuthenticated()">
<a class="login" href="<c:url value='/db/login'/>">log in</a>
</sec:authorize>
		
<sec:authorize access="isAuthenticated()">
<a class="login" href="<c:url value='/j_spring_security_logout'/>">logout!!</a>
</sec:authorize>