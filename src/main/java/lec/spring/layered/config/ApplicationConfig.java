package lec.spring.layered.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"lec.spring.layered.dao", "lec.spring.layered.services"})
@Import({DbConfig.class})
public class ApplicationConfig {

}
