<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP exemplo - resposta</title>
</head>
<body>

  <h1>Resposta JSP</h1>
  
  <%
	String nome = request.getParameter("nome");
	if(nome == null || nome.trim().isEmpty()) {
		nome = "Mundo";
	}
  %>
  
  Olá <%= nome %>
  
  <p><a href="hello.html"> Voltar </a>

</body>
</html>