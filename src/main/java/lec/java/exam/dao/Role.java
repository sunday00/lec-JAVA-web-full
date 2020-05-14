package lec.java.exam.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Role {

    private static final String dbUrl = "jdbc:mysql://127.0.0.1:3306/practice?characterEncoding=UTF-8&serverTimezone=UTC";
    private static final String dbUser = "Tester";
    private static final String dbPw = "Zktm500CC!";

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    lec.java.exam.dto.Role role = null;

    public List<lec.java.exam.dto.Role> getAllRole() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");

        String sql = "SELECT * FROM role";

        conn = DriverManager.getConnection(dbUrl, dbUser, dbPw);
        ps = conn.prepareStatement(sql);

        List <lec.java.exam.dto.Role> result = new ArrayList<lec.java.exam.dto.Role>();
        rs = ps.executeQuery();
        while( rs.next() ){
            int role_id = rs.getInt("role_id");
            String description = rs.getString("description");
            role = new lec.java.exam.dto.Role(role_id, description);
            result.add(role);
        }

        if (rs != null) {
            rs.close();
            ps.close();
            conn.close();
        }

        return result;
    }

    public lec.java.exam.dto.Role getRole(int roleId) throws SQLException, ClassNotFoundException{
        role = null;
        Class.forName("com.mysql.cj.jdbc.Driver");

        String sql = "SELECT role_id, description FROM role where role_id = ?";

        conn = DriverManager.getConnection(dbUrl, dbUser, dbPw);
        ps = conn.prepareStatement(sql);
        ps.setInt(1, roleId);
        rs = ps.executeQuery();

        if( rs.next() ){
            int role_id = rs.getInt("role_id");
            String description = rs.getString("description");

            role = new lec.java.exam.dto.Role(role_id, description);
        }

        if (rs != null) {
            rs.close();
            ps.close();
            conn.close();
        }

        return role;
    }

    public int addRole(lec.java.exam.dto.Role role) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String sql = "INSERT INTO role (role_id, description) VALUES (?,?)";
        lec.java.exam.dto.Role already = this.getRole(role.getRoleId());

        if( this.getRole(role.getRoleId()) == null ) {
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPw);
            ps = conn.prepareStatement(sql);
            ps.setInt(1, role.getRoleId());
            ps.setString(2, role.getDescription());

            return ps.executeUpdate();
        }

        return 0;
    }

    public int updateRole(lec.java.exam.dto.Role role) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String sql = "UPDATE role SET description=? WHERE role_id=?";

        if( this.getRole(role.getRoleId()) != null ) {
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPw);
            ps = conn.prepareStatement(sql);
            ps.setString(1, role.getDescription());
            ps.setInt(2, role.getRoleId());

            return ps.executeUpdate();
        }

        return 0;
    }

    public int deleteRole(int role_id) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String sql = "DELETE FROM role WHERE role_id=?";

        if( this.getRole(role_id) != null ) {
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPw);
            ps = conn.prepareStatement(sql);
            ps.setInt(1, role_id);

            return ps.executeUpdate();
        }

        return 0;
    }
}
