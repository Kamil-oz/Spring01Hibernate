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
<form:form method="post" modelAttribute="publisher">
		<form:input path="name" placeholder="Name" /><br>
		<form:input path="nip" placeholder="NIP" /><br>
		<form:input path="regon" placeholder="REGON" /><br>
		<input type="submit" value="Add publisher"><br>
	</form:form>

</body>
</html>