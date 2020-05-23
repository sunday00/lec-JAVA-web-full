package lec.spring.jdbc.runner;

import lec.spring.jdbc.config.ApplicationConfig;
import lec.spring.jdbc.dao.RoleDao;
import lec.spring.jdbc.dto.Role;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class SelectAllRole {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        RoleDao roleDao = ac.getBean(RoleDao.class);
        List<Role> roles = roleDao.selectAll();

        for(Role role : roles){
            System.out.println(role);
        }
    }
}
