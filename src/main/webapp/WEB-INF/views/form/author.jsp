<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
<form:form method="post" modelAttribute="author">
		<form:input path="firstName" placeholder="firstname" /><br>
		<form:input path="lastName" placeholder="lastname" /><br>
		<form:input path="pesel" placeholder="lastname" /><br>
		<form:input type="email" path="email" placeholder="email" /><br>
		<form:input type="number" path="yearOfBirth" min="0" step="1" placeholder="Year of birth" /><br>
		<input type="submit" value="Add author"><br>
	</form:form>

</body>
</html>