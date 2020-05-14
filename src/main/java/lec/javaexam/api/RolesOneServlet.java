package lec.javaexam.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import lec.javaexam.dao.RoleDao;
import lec.javaexam.dto.RoleDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/api/v1/role/*")
public class RolesOneServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8;");

        String path = request.getPathInfo();
        int id = Integer.parseInt( path.split("/")[1] );

        RoleDao dao = new RoleDao();
        try {
            RoleDto role = dao.getRole(id);
            ObjectMapper mapper = new ObjectMapper();

            PrintWriter pw = response.getWriter();
            pw.println( mapper.writeValueAsString(role) );

            pw.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
