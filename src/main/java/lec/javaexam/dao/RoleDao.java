package lec.javaexam.dao;

import lec.javaexam.dto.RoleDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoleDao {

    private static final String dbUrl = "jdbc:mysql://127.0.0.1:3306/practice?characterEncoding=UTF-8&serverTimezone=UTC";
    private static final String dbUser = "Tester";
    private static final String dbPw = "Zktm500CC!";

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    RoleDto role = null;

    public List<RoleDto> getAllRole() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");

        String sql = "SELECT * FROM role";

        conn = DriverManager.getConnection(dbUrl, dbUser, dbPw);
        ps = conn.prepareStatement(sql);

        List <RoleDto> result = new ArrayList<RoleDto>();
        rs = ps.executeQuery();
        while( rs.next() ){
            int role_id = rs.getInt("role_id");
            String description = rs.getString("description");
            role = new RoleDto(role_id, description);
            result.add(role);
        }

        if (rs != null) {
            rs.close();
            ps.close();
            conn.close();
        }

        return result;
    }

    public RoleDto getRole(int roleId) throws SQLException, ClassNotFoundException{
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

            role = new RoleDto(role_id, description);
        }

        if (rs != null) {
            rs.close();
            ps.close();
            conn.close();
        }

        return role;
    }

    public int addRole(RoleDto role) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String sql = "INSERT INTO role (role_id, description) VALUES (?,?)";
        RoleDto already = this.getRole(role.getRoleId());

        if( this.getRole(role.getRoleId()) == null ) {
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPw);
            ps = conn.prepareStatement(sql);
            ps.setInt(1, role.getRoleId());
            ps.setString(2, role.getDescription());

            return ps.executeUpdate();
        }

        return 0;
    }

    public int updateRole(RoleDto role) throws SQLException, ClassNotFoundException {
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
