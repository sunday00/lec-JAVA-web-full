package lec.spring.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public Car car (Engine engine) {
        Car car = new Car ();
        car.setEngine(engine);
        return car;
    }

    @Bean
    public Engine engine (){
        return new Engine();
    }
}
