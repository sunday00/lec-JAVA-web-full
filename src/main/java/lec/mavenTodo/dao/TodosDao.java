package lec.mavenTodo.dao;

import lec.mavenTodo.dto.TodoDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TodosDao {
    private static final String dbUrl = "jdbc:mysql://127.0.0.1:3306/practice?characterEncoding=UTF-8&serverTimezone=UTC";
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
            todos = new TodoDto();
            todos.setId(id);
            todos.setTitle(title);
            todos.setName(name);
            todos.setSequence(sequence);
            todos.setType(type);
            result.add(todos);
        }

        if (rs != null) {
            rs.close();
            ps.close();
            conn.close();
        }

        return result;
    }

}
