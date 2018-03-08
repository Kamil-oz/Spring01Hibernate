<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Books</title>
</head>
<body>
	<ol>
		<c:forEach items="${books}" var="book">
			<li>${book.title} 
			<a href="${book.proposition?"proposition":"book"}/delete/${book.id}" ><button>Usuń</button></a>
			<a href="${book.proposition?"proposition":"book"}/edit/${book.id}" ><button>Edytuj</button></a></li>
		</c:forEach>
	</ol>
</body>
</html>