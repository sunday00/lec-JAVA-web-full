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
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/api/v1/todos")
public class TodosServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        TodosDao dao = new TodosDao();
        List<TodoDto> todos = null;
        try {
            todos = dao.getAllTodos();
        } catch (SQLException | ClassNotFoundException throwables ) {
            throwables.printStackTrace();
        }
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(todos);

        PrintWriter pw = response.getWriter();
        pw.println(json);
        pw.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        TodosDao dao = new TodosDao();
        TodoDto todo = null;

        try {
            todo = dao.insertTodo(request);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(todo);

        PrintWriter pw = response.getWriter();
        pw.println(json);
        pw.close();
    }
}
