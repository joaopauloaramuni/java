<html>
  <head>
    <title>Hello JSP</title>
  </head>

  <body>
    <%
      String user = request.getParameter("usuario");
      if (user == null) user = "World";
    %>
    <h1>Hello JSP</h1>
    <p>Hello, <%= user %></p>
  </body>
</html>