import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class data extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String num1 = request.getParameter("num1");
        String num2 = request.getParameter("num2");

        out.println("<html><body>");
        out.println("<h1>Data Servlet</h1>");
        out.println("<p>This is a simple servlet that handles GET requests.</p>");
        out.println("<p>Number 1: " + num1 + "</p>");
        out.println("<p>Number 2: " + num2 + "</p>");
        out.println("</body></html>");

        out.close();
    }
}