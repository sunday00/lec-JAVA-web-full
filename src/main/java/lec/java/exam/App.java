package lec.java.exam;

import lec.java.exam.dao.Role;

import java.sql.SQLException;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException, ClassNotFoundException {
        Role dao = new Role();
        lec.java.exam.dto.Role role = dao.getRole(100);

        System.out.printf("get one role" + role.toString());

        lec.java.exam.dto.Role role2 = new lec.java.exam.dto.Role(103, "Project Manager");
        dao.addRole(role2);
        System.out.printf("add one role" + role2.toString());

        lec.java.exam.dto.Role role3 = new lec.java.exam.dto.Role(103, "UPDATED Manager");
        System.out.printf("update one role success? " + dao.updateRole(role3)+"\n");

        Role dao3 = new Role();
        List <lec.java.exam.dto.Role> roles = dao3.getAllRole();

        System.out.println("Get all roles : " + roles.toString());

        for( lec.java.exam.dto.Role member: roles ){
            System.out.println("role: " + member.toString());
        }

        Role dao2 = new Role();
        System.out.printf("is success delete? : " + dao2.deleteRole(103)+"\n");

        List <lec.java.exam.dto.Role> roles2 = dao3.getAllRole();

        System.out.println("Get all roles : " + roles2.toString());
    }
}
