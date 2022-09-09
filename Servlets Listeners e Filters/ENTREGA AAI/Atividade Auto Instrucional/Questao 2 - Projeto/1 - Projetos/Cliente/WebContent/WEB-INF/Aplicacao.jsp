<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="estilo.css">
<title>Validador de CPF</title>
</head>
<body>
	<div class="top">
		<div><img style="border:none; width:75px; height:70px;" src="fumec.png"/></div>
	</div>
	<div class="superPag">
		<div class="paginas">
			<h1><span>Validar CPF</span></h1>
			<form method="post">
				<table width="100%">
					<tr>
						<td><span class="texto">CPF:</span></td>
						<td>
							<input class="txt" type="text" name="cpf" />
						</td>
					</tr>
				</table>
				<br>
				<table width="100%">
					<tr>
						<td align="right"><input class="btn" type="submit" name="inserir"
							value="Validar" /></td>
						<td align="left"><input class="btn" type="reset" name="limpar"
							value="Limpar" /></td>
					</tr>
				</table>
			</form>
				<br>
				<%= request.getAttribute("resposta") %>
		</div>
	</div>
</body>
</html>