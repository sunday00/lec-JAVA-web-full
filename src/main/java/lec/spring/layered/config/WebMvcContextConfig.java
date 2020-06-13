package lec.spring.layered.config;

import middleware.GuestBookInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import resolver.HandlerMapArgumentResolver;
import resolver.JustGetAppleStringArgumentResolver;

import java.util.List;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "lec.spring.layered.controllers" })
public class WebMvcContextConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
        registry.addResourceHandler("/css/**").addResourceLocations("/resources/css/").setCachePeriod(31556926);
        registry.addResourceHandler("/js/**").addResourceLocations("/resources/js/").setCachePeriod(31556926);
        registry.addResourceHandler("/img/**").addResourceLocations("/resources/img/").setCachePeriod(31556926);
    }

    // when request doesn't have any configuration that mapping, allow spring can process default handler;
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        super.configureDefaultServletHandling(configurer);
        configurer.enable();
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        super.addViewControllers(registry);
        registry.addViewController("/").setViewName("main");
    }

    @Bean
    public InternalResourceViewResolver getInternalViewResolver() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/WEB-INF/views/");
        internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(new GuestBookInterceptor()).addPathPatterns("/auth/**");
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        super.addArgumentResolvers(argumentResolvers);
        argumentResolvers.add(new HandlerMapArgumentResolver());
        argumentResolvers.add(new JustGetAppleStringArgumentResolver());
    }
}
