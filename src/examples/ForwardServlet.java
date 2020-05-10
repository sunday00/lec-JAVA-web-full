package examples;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/forward")
public class ForwardServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.service(req, resp);

        double randNum =  Math.random() * 6;
        // Math.random() : 0.0...01 ~ 0.999..
        // Math.random() * 6 : 0.00...6 ~ 5.99...4
        int diceNum = (int)( randNum + 1);
        // int( Math.random() ) : 0 ~ 5
        // int( Math.random() + 1 ) : 1 ~ 6
        req.setAttribute("diceNum", diceNum);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/to");
        System.out.println(req.getAttribute("diceNum"));
        requestDispatcher.forward(req, resp);
    }
}
