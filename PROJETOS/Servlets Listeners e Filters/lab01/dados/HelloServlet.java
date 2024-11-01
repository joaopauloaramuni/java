import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloServlet extends HttpServlet {
  public void doGet (HttpServletRequest request,
                     HttpServletResponse response) 
              throws ServletException, IOException {

    PrintWriter out;
    response.setContentType("text/html");
    out = response.getWriter();
    String user = request.getParameter("usuario");
    if (user == null)
      user = "World";

    out.println("<html><head><title>");
    out.println("Hello Servlet");
    out.println("</title></head><body>");
    out.println("<h1>Hello Servlet</h1>");
    out.println("<p>Hello, " + user + "</p>");
    out.println("</body></html>");
    out.close();
  }
}