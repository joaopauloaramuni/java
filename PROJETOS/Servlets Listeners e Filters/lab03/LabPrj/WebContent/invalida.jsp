<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Invalidação de sessão</title>
</head>
<body>
<h1>Invalidação de Sessão</h1>
<% session.invalidate(); %>
Sessão invalidada.
</body>
</html>