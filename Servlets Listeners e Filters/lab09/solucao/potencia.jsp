<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%! 
	private double potencia (double base, int expoente) {		
		if (expoente == 0)
			return 1.0;		
		if (expoente < 0) 
			return 1.0 / potencia (base, -expoente);		
		if (expoente % 2 == 0) {
			double d = potencia (base, expoente / 2);
			return d*d;
		}		
		return base * potencia (base, expoente-1);
	}
%>

<% 
   String baseStr = request.getParameter("base");
   String expoenteStr = request.getParameter("expoente");
   double base = 0.0;
   int expoente = 0;
   String mensagem = "";
   if (baseStr != null && expoenteStr != null)
     try {
	   base = Double.parseDouble(baseStr);
	   expoente = Integer.parseInt(expoenteStr);
	   mensagem = "Resultado = " + potencia(base,expoente);
     } catch (NumberFormatException e) {
       mensagem = "Informações incorretas";
     }
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cálculo de potência</title>
</head>
<body>
 <h1>Cálculo de Potência (JSP)</h1>
 <form method="post">
   Base (real): <input type="text" name="base"><br>
   Expoente (inteiro): <input type="text" name="expoente"><br>
   <input type="submit">
 </form>
 <%= mensagem %>
 <a href="login.jsp">Sair</a>
</body>
</html>