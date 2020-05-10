package examples;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/to")
public class ToServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);

        resp.setContentType("text/html;charset=UTF-8;");
        PrintWriter out = resp.getWriter();
        out.println("<h1> "+ req.getAttribute("diceNum") +" </h1>");
        out.close();
    }
}
