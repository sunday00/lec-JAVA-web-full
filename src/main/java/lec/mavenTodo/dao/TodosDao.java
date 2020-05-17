package lec.mavenTodo.dao;

import lec.mavenTodo.dto.TodoDto;

import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TodosDao {
    private static final String dbUrl = "jdbc:mysql://127.0.0.1:3306/practice?characterEncoding=UTF-8&serverTimezone=Asia/Seoul";
    private static final String dbUser = "Tester";
    private static final String dbPw = "Zktm500CC!";

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    TodoDto todos = null;

    public List<TodoDto> getAllTodos() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");

        String sql = "SELECT * FROM todo";

        conn = DriverManager.getConnection(dbUrl, dbUser, dbPw);
        ps = conn.prepareStatement(sql);

        List <TodoDto> result = new ArrayList<TodoDto>();
        rs = ps.executeQuery();
        while( rs.next() ){
            int id = rs.getInt("id");
            String title = rs.getString("title");
            String name = rs.getString("name");
            int sequence = rs.getInt("sequence");
            String type = rs.getString("type");
            Timestamp regDate = rs.getTimestamp("regDate");
            todos = new TodoDto();
            todos.setId(id);
            todos.setTitle(title);
            todos.setName(name);
            todos.setSequence(sequence);
            todos.setType(type);
            todos.setRegDate(regDate.toLocalDateTime());
            result.add(todos);
        }

        if (rs != null) {
            rs.close();
            ps.close();
            conn.close();
        }

        return result;
    }

    public TodoDto insertTodo(HttpServletRequest request) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String sql = "INSERT INTO todo (title, name, sequence, type) VALUES (?, ?, ?, 'todo')";

        conn = DriverManager.getConnection(dbUrl, dbUser, dbPw);
        ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, request.getParameter("title"));
        ps.setString(2, request.getParameter("name"));
        ps.setInt(3, Integer.parseInt( request.getParameter("sequence") ));

        TodoDto todo = null;
        int id = 0;

        ps.executeUpdate();
        rs = ps.getGeneratedKeys();
        while (rs.next()){
            id = rs.getInt(1);
        }

        if( id != 0 ){
            todo = new TodoDto();
            todo.setId(id);
            todo.setTitle(request.getParameter("title"));
            todo.setName(request.getParameter("name"));
            todo.setSequence(Integer.parseInt( request.getParameter("sequence") ));
            todo.setType("todo");
            todo.setRegDate(LocalDateTime.now());
        }

        return todo;
    }
}
