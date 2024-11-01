<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--Exemplo de Scriplet -->
<%
	String s = "Esta � uma vari�vel local";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Exemplo JSP</title>
</head>
<body>
	
	<h1>Exemplo JSP</h1>
	
	Este � um JSP de exemplo.
	
	<!--Exemplo de Expression -->
	<br>Outra exibi��o: <%= s %>
	
	<!--Exemplo de Scriplet -->
	<br><% out.println(s); %>
	
	<p>
	<!--Exemplo de Loop com Scriplet -->
	<% 
		out.println("<br>");
		for (int i = 1; i <= 10; i++)
		out.println(i + " ");
	%>
	<br>
	<!--Exemplo de Loop com Expression -->
	<% for (int i = 1; i <= 10; i++) { %>
		<%="" + i %>
	<% } %>
	<p>Data/hora atuais: <%= new java.util.Date() %>
	
	<%-- Coment�rio JSP --%>
	<%-- 1) Diretivas: <%@ Diretiva atributo1, atributo2 %> --%>
	<%-- 2)	Declara��es: <%! Atributos, m�todos, classes internas%> --%>
	<%-- 3)	Express�es: <%= ... %> --%>
	<%-- 4)	Scriplets: <% c�digo Java gen�rico %> --%>
	
	<%-- Objetos Impl�citos: request, response, session, out, application = context --%>
	<%-- session="false" - n�o criar� a sess�o automaticamente --%>
	
	<!-- Redirecionando para p�gina de erro caso haja algum. -->
	<%@ page errorPage="erro.jps" %>
	
</body>
</html>