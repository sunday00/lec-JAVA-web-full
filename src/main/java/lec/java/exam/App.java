package lec.java.exam;

import lec.java.exam.dao.Role;

import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {
        Role dao = new Role();
        lec.java.exam.dto.Role role = dao.getRole(100);

        System.out.printf(role.toString());
    }
}
