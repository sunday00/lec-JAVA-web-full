package lec.spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        UserBean userBean = (UserBean) applicationContext.getBean("userBean");
        userBean.setName("sunday00");
        userBean.setAge(35);
        userBean.setMale(true);

        UserBean userBean2 = (UserBean) applicationContext.getBean("userBean");

        System.out.println(userBean.toString());
        System.out.println(userBean == userBean2);

        userBean2.setName("Kong");

        System.out.println(userBean.toString());
    }
}
