package lec.mavenTodo.dao;

import lec.mavenTodo.dto.TodoDto;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    public TodoDto getOneTodo(int id) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String sql = "SELECT * FROM todo WHERE id = ?";

        conn = DriverManager.getConnection(dbUrl, dbUser, dbPw);
        ps = conn.prepareStatement(sql);
        ps.setInt(1, id);

        TodoDto todo = new TodoDto();
        rs = ps.executeQuery();
        while( rs.next() ){
            todo.setId(rs.getInt("id"));
            todo.setName(rs.getString("name"));
            todo.setRegDate(rs.getTimestamp("regDate").toLocalDateTime());
            todo.setSequence(rs.getInt("sequence"));
            todo.setTitle(rs.getString("title"));
            todo.setType(rs.getString("type"));
        }

        if( rs != null ){
            rs.close();
            ps.close();
            conn.close();
        }

        return todo;
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

    public int updateType(HttpServletRequest request) throws IOException, ClassNotFoundException, SQLException {
        String[] splitedUri = request.getRequestURI().split("/");
        int id = Integer.parseInt( splitedUri[splitedUri.length - 1] );

        String data = inputStreamToString(request.getInputStream());
        String[] splitedData = data.split("=");
        String type = splitedData[ splitedData.length - 1 ];
        System.out.println(type);
        type = type.equals("todo") ? "doing" : "done";
        System.out.println(type);

        int result = 0;

        Class.forName("com.mysql.cj.jdbc.Driver");

        String sql = "UPDATE todo SET type=? WHERE id= ? ";

        conn = DriverManager.getConnection(dbUrl, dbUser, dbPw);
        ps = conn.prepareStatement(sql);
        ps.setString(1, type);
        ps.setInt(2, id);
        if( ps.executeUpdate() > 0){
            result = id;
        }

        return result;
    }

    public int deleteTodo(HttpServletRequest request) throws ClassNotFoundException, SQLException {
        int result = 0;

        String[] splitedUri = request.getRequestURI().split("/");
        int id = Integer.parseInt( splitedUri[splitedUri.length - 1] );

        Class.forName("com.mysql.cj.jdbc.Driver");
        String sql = "DELETE FROM todo WHERE id=?";

        conn = DriverManager.getConnection(dbUrl, dbUser, dbPw);
        ps = conn.prepareStatement(sql);
        ps.setInt(1, id);

        if ( ps.executeUpdate() > 0 ) {
            result = id;
        }

        return result;
    }

    private static String inputStreamToString(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream, "UTF-8");
        return scanner.hasNext() ? scanner.useDelimiter("\\A").next() : "";
    }
}
