package examples;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Scanner;

@WebServlet("/json")
public class SampleJsonReturnerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8;");
        PrintWriter out =  response.getWriter();
        out.println("<html><head><title>Doc</title></head><body>");

        String line = null;
        BufferedReader reader = request.getReader();
        while((line = reader.readLine()) != null) {
            out.println(line);
        }

        out.println("</body>");
        out.println("</html>");
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String path = getServletContext().getRealPath("./JStest");
        File file = new File(path + "/Sample.json");
        Scanner scan = new Scanner(file);

        while(scan.hasNextLine()){
            out.println(scan.nextLine());
        }

        out.close();
    }
}
