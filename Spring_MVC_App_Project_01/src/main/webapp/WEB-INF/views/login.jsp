<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Form</title>
</head>
<body>
  <form:form action="loginCheck" method="post">
     <div align="center">
	     <label>User Name</label><br>
	     <input type="text" name="name" placeholder="User Name"><br>
	     <label>Password</label><br>
	     <input type="password" name="pwd" placeholder="Password">
	     <div style="margin-top:10px">
	       <button>Submit</button>
	     </div>
     </div>
  </form:form>
</body>
</html>