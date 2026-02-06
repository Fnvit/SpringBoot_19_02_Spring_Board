package com.example.board.configuration;

import com.example.board.interceptor.AuthenticationInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class ApplicationConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        AuthenticationInterceptor authenticationInterceptor = new AuthenticationInterceptor();
        registry.addInterceptor(authenticationInterceptor)
                .addPathPatterns("/board/**");
    }
}
