<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cálculo de exponencial</title>
</head>
<body>
	<h1>Laboratório 11</h1>
		<form method="post">
			Valor de x: <input type="text" name="x"/>
			<br>
			<input type="submit"/>
		</form>
		<%= request.getAttribute("msg") %>
		<br>Precisão: <%= session.getAttribute("precisao") %>
		<br>
		<a href="precisao.jsp">Voltar</a>
</body>
</html>