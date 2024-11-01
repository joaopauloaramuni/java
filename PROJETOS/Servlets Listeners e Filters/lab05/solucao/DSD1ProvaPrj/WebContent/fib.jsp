<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
  String chave = (int)(Math.random() * 100000) + "";
  session.setAttribute("chave",chave);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Série de Fibonacci</title>
</head>
<body>
  <h1>Série de Fibonacci</h1>
  <form method="post" action="calc">
    Elemento da série: <input type="text" name="elemento"><br>
    Chave: <input type="text" name="chave"> <%= chave %><br>
    <input type="submit">
  </form>
</body>
</html>