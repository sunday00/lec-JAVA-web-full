package lec.spring.jdbc.runner;

import lec.spring.jdbc.config.ApplicationConfig;
import lec.spring.jdbc.dao.RoleDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SelectOneRole {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        RoleDao roleDao = ac.getBean(RoleDao.class);

        System.out.println( roleDao.selectOne(100) );
    }
}
