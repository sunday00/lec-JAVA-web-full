package lec.javaexam.api;

import java.io.PrintWriter;
import java.sql.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import lec.javaexam.dao.RoleDao;
import lec.javaexam.dto.RoleDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/api/v1/role")
public class RolesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8;");
        RoleDao dao = new RoleDao();
        try {
            List<RoleDto> roles = dao.getAllRole();
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(roles);

            PrintWriter pw = response.getWriter();
            pw.println(json);
            pw.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
