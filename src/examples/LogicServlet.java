package examples;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/logic")
public class LogicServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int result = (int)((Math.random() * 100 + 1) + (Math.random() * 100 + 1));

        req.setAttribute("result", result);
        req.getRequestDispatcher("/JSPTest/front.jsp").forward(req, resp);
    }
}
