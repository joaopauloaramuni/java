<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Jogo Sorteio</title>
</head>
<body>
	<h1>Jogo</h1>
	<form method="post">
		Lance: <input type="text" name="lance" /><br><input type="submit" />
	</form>
	<br>
	<%= request.getAttribute("resposta") %>
	<br>
	<a href="jogo">Reiniciar</a>
</body>
</html>