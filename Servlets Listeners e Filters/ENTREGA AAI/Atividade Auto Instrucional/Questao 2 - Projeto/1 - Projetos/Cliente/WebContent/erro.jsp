<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page isErrorPage="true" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Página de erro</title>
</head>
<body>
	<h2>Página de erro</h2>
	<h3>Erro ocorrido:</h3>
	<div style="width: 450px;"><%= exception %></div>
	<br><a href="CPFServlet">Voltar</a>
</body>
</html>