package examples;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/info")
public class InfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8;");
        PrintWriter out =  response.getWriter();
        out.println("<html><head><title>Doc</title></head><body>");

        out.println(request.getRequestURL() + "<br />" + request.getRequestURI() + "<br />" + request.getContextPath() + "<br />" + request.getRemoteAddr() + "<br />" + request.getLocalAddr());

        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
