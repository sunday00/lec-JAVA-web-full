package lec.spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextMain3 {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
//        Car car = (Car) ac.getBean("car");
        Car car = ac.getBean(Car.class);
        car.run();
    }
}
