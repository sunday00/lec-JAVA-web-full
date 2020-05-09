package examples;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/header")
public class HeaderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8;");
        PrintWriter out =  response.getWriter();
        out.println("<html><head><title>Doc</title></head><body>");

        Enumeration<String> headers =  request.getHeaderNames();
        while ( headers.hasMoreElements() ){
            String k = headers.nextElement();
            out.println( k + " : " + request.getHeaders(k) + "<br />" );
        }

        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
