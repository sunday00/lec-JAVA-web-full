package lec.java.exam.dao;

import java.sql.*;

public class Role {

    private static final String dbUrl = "jdbc:mysql://127.0.0.1:3306/practice?characterEncoding=UTF-8&serverTimezone=UTC";
    private static final String dbUser = "Tester";
    private static final String dbPw = "Zktm500CC!";

    public lec.java.exam.dto.Role getRole(int roleId) throws SQLException {
        lec.java.exam.dto.Role role = null;
        String sql = "SELECT role_id, description FROM role where role_id = ?";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
//            Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPw);
            ps = conn.prepareStatement(sql);
            ps.setInt(1, roleId);
            rs = ps.executeQuery();

            if( rs.next() ){
                int role_id = rs.getInt("role_id");
                String description = rs.getString("description");

                role = new lec.java.exam.dto.Role(role_id, description);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
                ps.close();
                conn.close();
            }
        }

        return role;
    }
}
