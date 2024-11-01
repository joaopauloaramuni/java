<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<% 
String resposta = "";

if("POST".equals(request.getMethod())){
	try{
		
		double precisao = Double.parseDouble(request.getParameter("precisao"));
		if(precisao <= 0.0 || precisao >=1.0)
			resposta = "Precis�o inv�lida(deve estar entre 0.0 e 1.0)";
		else{
			session.setAttribute("precisao", precisao);
			response.sendRedirect("calculo");
			return;
		}
	}catch(NumberFormatException e){
			resposta = "Favor informar um n�mero real entre 0.0 e 1.0";
	}
	
}

%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Precis�o</title>
	</head>
	<body>
		<h1>Laborat�rio 11</h1>
		<form method="post">
			Precis�o: <input type="text" name="precisao"/>
			<br>
			<input type="submit" name="btnSubmit"/>
		</form>
		<br>
		<%=resposta %>
	</body>
</html>