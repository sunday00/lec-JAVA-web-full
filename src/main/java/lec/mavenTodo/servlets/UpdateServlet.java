package lec.mavenTodo.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import lec.mavenTodo.dao.TodosDao;
import lec.mavenTodo.dto.TodoDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Scanner;

@WebServlet("/api/v1/todos/*")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        TodosDao dao = new TodosDao();
        int result = 0;
        TodoDto todo = null;

        try {
            result = dao.updateType(request);
            if(result > 0){
                todo = dao.getOneTodo(result);
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(todo);

        PrintWriter pw = response.getWriter();
        pw.println(json);
        pw.close();
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        TodosDao dao = new TodosDao();
        int result = 0;

        try {
            result = dao.deleteTodo(request);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(result);

        PrintWriter pw = response.getWriter();
        pw.println(json);
        pw.close();
    }
}
