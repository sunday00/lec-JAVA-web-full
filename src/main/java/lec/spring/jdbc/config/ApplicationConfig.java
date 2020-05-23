package lec.spring.jdbc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"lec.spring.jdbc.dao"})
@Import({DbConfig.class})
public class ApplicationConfig {

}
