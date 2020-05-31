package lec.sunday00.reservation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = { "lec.sunday00.reservation.model", "lec.sunday00.reservation.repository", "lec.sunday00.reservation.service"})
@Import({DbConfig.class})
public class ApplicationConfig {
}
