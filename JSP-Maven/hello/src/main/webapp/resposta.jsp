<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Titulo</title>
</head>
<body>
	<h2>Obrigado</h2>
	<c:forEach var="t" items="${lista}">
		<h3>${t.nome} - {$t.descricao}</h3>
	</c:forEach>
</body>
</html>