<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Person Form</title>
</head>
<body>
	<form:form modelAttribute="person" method="post">
		<form:input path="login" placeholder="login" />
		<form:input type="password" path="password" placeholder="password" />
		<form:input type="email" path="email" placeholder="email" />
		<form:select items="${groups}" path="group.id" itemLabel="name"
			itemValue="id" />
		<input type="submit" value="save" />
	</form:form>
</body>
</html>