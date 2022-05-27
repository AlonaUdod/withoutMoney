package com.withoutmoney.config;

import com.withoutmoney.entity.User;
import com.withoutmoney.service.UserService;
import com.withoutmoney.source.UserSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@Configuration
public class SpringConfig {

    @Bean
    public UserSource userSource(){
        return new UserSource(new JdbcTemplate());
    }

    @Bean
    public UserService userService () {
        return new UserService(userSource());
    }

    @Bean
    public User user(){
        return new User();
    }

    @Bean
    public ClassLoaderTemplateResolver userClassLoaderTemplateResolver() {
        ClassLoaderTemplateResolver classLoaderTemplateResolver = new ClassLoaderTemplateResolver();
        classLoaderTemplateResolver.setPrefix("templates/user/");
        classLoaderTemplateResolver.setSuffix(".html");
        classLoaderTemplateResolver.setTemplateMode(TemplateMode.HTML);
        classLoaderTemplateResolver.setCharacterEncoding("UTF-8");
        classLoaderTemplateResolver.setOrder(0);
        classLoaderTemplateResolver.setCheckExistence(true);

        return classLoaderTemplateResolver;
    }


}
