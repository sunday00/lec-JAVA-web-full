package examples;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/page-context")
public class PageContextServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8;");
        System.out.println(request.hashCode());
        HttpSession session = request.getSession();
        session.setAttribute("beta", "B");
        ServletContext context = request.getServletContext();
        context.setAttribute("gamma", "C");
        request.getRequestDispatcher("/scope/pageContext.jsp").forward(request,response);
    }
}
