<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>detailedpersonform</title>
</head>
<body>
	<form:form modelAttribute="persondto" method="post" action="person/showform">
		<form:input type="text" path="login" placeholder="login"/>
		<br>
		<form:input type="password" path="password" placeholder="password"/>
		<br>
		<form:input type="email" path="email" placeholder="email"/>
		<br>
		<form:input type="text" path="firstName" placeholder="First Name"/>
		<br>
		<form:input type="text" path="lastName" placeholder="Last Name"/>
		<br>
		Male:<form:radiobutton path="gender" value="M" />
		Female:<form:radiobutton path="gender" value="F" />
		<br>
		<form:select path="country" items="${countries}"  />
		<br>
		<form:input type="textarea" path="notes" placeholder="notes" />
		<br>
		Spam <form:checkbox path="mailingList" /><br>
		<form:select path="programmingSkills" items="${programmingSkills}"  />
		<br>
		<form:checkboxes items="${hobbies}" path="hobbies" />
		<input type="submit" value="save" />
	</form:form>
</body>
</html>