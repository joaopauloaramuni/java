<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Data JSP</title>
</head>
<body>

	<h1>Cálculo de Datas</h1>
	<%=request.getAttribute("redirecao")%>
	<h4>Informe a data de conclusão:</h4>
	<form method="post" action="data">
		<table>
			<tr>
				<td>Dia:</td>
				<td><input type="text" name="dia" /></td>
			</tr>
			<tr>
				<td>Mês:</td>
				<td><input type="text" name="mes" /></td>
			</tr>
			<tr>
				<td>Ano:</td>
				<td><input type="text" name="ano" /></td>
			</tr>
			<tr>
				<td><br><input type="submit" value="enviar" name="enviar"/></td>
			</tr>
			<tr>
				<td>

				</td>
			</tr>
		</table>
	</form>
	<br>
	<%=(request.getAttribute("mensagem") != null) ? request.getAttribute("mensagem").toString() : ""%>
</body>
</html>