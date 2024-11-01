<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Prova Final</title>
</head>
<body>
	<h1>Prova</h1>
	<form method="post">
		Operador: <input type="text" name="operador" /><br><br><input type="submit" />
	</form>
	<br>
	<%= request.getAttribute("resposta") %>
	<br><br>
	<a href="prova">Reiniciar</a>
</body>
</html>