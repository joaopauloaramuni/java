<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% String msg = "";
       String precisao = (request.getParameter("precisao") != null) ? request.getParameter("precisao").toString() : "";
		if(!precisao.equals("")){
			session.setAttribute("precisao", precisao); 
			// Redireciona (definitivamente) a requisi��o para outro componente
			request.setAttribute("redirecao", "Redirecionado via forward - GET");
			RequestDispatcher rd = request.getRequestDispatcher("/funcao");
			rd.forward(request, response);
		}else{
			msg = "Informe a precis�o para continuar.";
		}
	
	%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fun��o Exponencial</title>
</head>
<body>
<h1>Laborat�rio 11</h1>
<form method="post">
		<table>
			<tr>
				<td>Precis�o Desejada:</td>
				<td><input type="text" name="precisao" /></td>
				<td><input type="submit" name="btnprecisao" /></td>
				<%= msg %>
			</tr>
		</table>
	</form>
</body>
</html>