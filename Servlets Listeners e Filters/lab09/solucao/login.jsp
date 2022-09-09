<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%
  String mensagem = "";

  if ("GET".equals(request.getMethod())) {
	  session = request.getSession(false);
      if (session != null)
         session.invalidate();
  }
  else {
      String userName = request.getParameter("userName");
      String password = request.getParameter("password");
      if (userName != null && password != null && userName.equals("flavio") && password.equals("1234")) {
		session.setAttribute("logado", new Boolean(true));
		response.sendRedirect("potencia.jsp");
	  }
      else {
    	  mensagem = "<br>Login falhou. Tente novamente.";
      }
  }
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
  <h1>Login (JSP)</h1>
  <%= mensagem %>
  Informe seu código e senha.<br>
  <form method=post>
    Código: <input type=text name=userName><br>
    Senha: <input type=password name=password><br>
    <input type=submit>
  </form>
</body>
</html>