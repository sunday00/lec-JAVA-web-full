package examples;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/intro")
public class IntroduceServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));

        String page = request.getParameter("page");
        if (request.getParameter("page") == null){
            page = "index";
        }

        request.setAttribute("url", request.getRequestURL());
        request.setAttribute("time", time);

        request.getRequestDispatcher("/intro/"+page+".jsp").forward(request, response);
    }
}
