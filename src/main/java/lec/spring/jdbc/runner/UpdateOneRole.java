package lec.spring.jdbc.runner;

import lec.spring.jdbc.config.ApplicationConfig;
import lec.spring.jdbc.dao.RoleDao;
import lec.spring.jdbc.dto.Role;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UpdateOneRole {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        RoleDao roleDao = ac.getBean(RoleDao.class);

        Role role = new Role();
        role.setRoleId(500);
        role.setDescription("React Developer");

        System.out.println( roleDao.updateOne(role) );
    }
}
