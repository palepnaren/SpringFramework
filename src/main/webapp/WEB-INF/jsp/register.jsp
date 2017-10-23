<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/db/style/style.css">
<title>Create Account!!</title>
</head>
<body>
  <h2>Register Account.</h2>
	<f:form method="post"  action="${pageContext.request.contextPath}/db/created" commandName="user" id="list">
	<table id="form-table">
		<tr><td>Username:</td><td><f:input type="text" name="username" path="username" placeholder="enter username"/><br><f:errors path="username" cssClass="error"></f:errors></td></tr>
		<tr><td>Password:</td><td><f:input id="pwd" path="password" name="password" type="password" placeholder="enter password"/><br><f:errors path="password" cssClass="error"></f:errors></td></tr>
		<tr><td>Cnf_Pwd:</td><td><input id="cnf_pwd" type="password" name="cnf_pwd" placeholder="confirm password"/><br><p class="error"></p></td></tr>
		<tr><td><input type="submit" value="sign up!"></td></tr>
	</table>
	</f:form>
	<p><a href="${pageContext.request.contextPath}/db">Click here to Home page!</a></p>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript">
	   $(function(){
		   
		   function passwordMatch(){
			  $pwd = $("#pwd").val();
			  $cnf_pwd = $("#cnf_pwd").val();
			  
			  if($pwd.length<3 || $cnf_pwd.length<3){
				  return;
			  }
			  
			  if($pwd == $cnf_pwd){
				  $("p.error").css("color","green");
				  $("p.error").text("<fmt:message key="Match.user.password"></fmt:message>");
			  }else{
				  $("p.error").css("color","red");
				  $("p.error").text("<fmt:message key="MissMatch.user.password"></fmt:message>")
			  }
			  
		   }
		  
		  $("#pwd").on("input",passwordMatch)
		  $("#cnf_pwd").on("input",passwordMatch)
		  
		  $("#list").on("submit",function(){
			  $pwd = $("#pwd").val();
			  $cnf_pwd = $("#cnf_pwd").val();
			  if($pwd == $cnf_pwd){
				  return true;
			  }else{
				  return false;
			  }
		  });
	   });
	</script>
	
	
</body>
</html>