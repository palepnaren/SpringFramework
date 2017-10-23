<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>
    <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/db/style/style.css">
<title><tiles:insertAttribute name="title"></tiles:insertAttribute></title>

</head>
<body>

<div class="header">
<tiles:insertAttribute name="header"/>
</div>

<div class="body">
<tiles:insertAttribute name="body"/>
 </div>
 
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>  
</body>
<hr>
<div class="footer">
<tiles:insertAttribute name="footer"/>
</div>
</html>