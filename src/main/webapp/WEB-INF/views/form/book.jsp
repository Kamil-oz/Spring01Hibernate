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
	<form:form modelAttribute="book" method="post">
		<form:input path="title" placeholder="title" /><br>
		<form:errors path="title" /><br>
		<form:textarea path="description" placeholder="description" /><br>
		<form:errors path="description" /><br>
		<form:select path="publisher" items="${publishers}" itemValue="id"
			itemLabel="name" /><br>
		<form:errors path="publisher" /><br>
		<form:input path="pages" type="number" min="1" step="1" />
		<form:errors path="pages"/>
		<form:input path="rating" type="number" max="10" min="1" step="1"
			value="5" /><br>
		<form:errors path="rating" /><br>
		Proposition?<form:checkbox path="proposition" /><br>
		<form:errors path="*" /><br>
		<input type="submit" value="save" />
	</form:form>
</body>
</html>