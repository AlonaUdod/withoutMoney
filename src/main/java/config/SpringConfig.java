package config;

import entity.User;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import source.UserSource;

@Configuration
@PropertySource("classpath:application.properties")
public class SpringConfig {

    @Bean
    public UserSource userSource(){
        return new UserSource();
    }

    @Bean
    public User user(){
        return new User();
    }

}
