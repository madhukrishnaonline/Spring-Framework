<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Response</title>
</head>
<body>
  <div align="center">
    <h1>${isLoginSuccessOrNot}</h1>
    
    <h1>${loginSuccess}</h1>
    <dl>
      <dt>First Name</dt>
      <dd>=> ${fName}</dd>
      <dt>Last Name</dt>
      <dd>=> ${lName}</dd>
      <dt>Qualification</dt>
      <dd>=> ${qualify}</dd>
      <dt>Gender</dt>
      <dd>=> ${gender}</dd>
    </dl>
  </div>
</body>
</html>