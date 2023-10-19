<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Form</title>
</head>
<body>
   <form:form action="register" method="post">
      <div align="center">
        <label>First Name</label><br>
        <input type="text" name="fName"><br>
        <label>Last Name</label><br>
        <input type="text" name="lName"><br>
        <label>Qualification</label><br>
        <input type="text" name="qualify"><br>
        <label>UG Percentage %</label><br>
        <input type="number" name="percent"><br>
        <label>Gender</label><br>
        <input type="radio" name="gender" value="male">
        <input type="radio" name="gender" value="female">
      <div style="margin-top: 10px">
         <button>Submit</button>
      </div>
      </div>
   </form:form>
</body>
</html>