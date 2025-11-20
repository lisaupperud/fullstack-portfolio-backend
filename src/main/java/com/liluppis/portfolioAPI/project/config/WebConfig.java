package com.liluppis.portfolioAPI.project.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**") // apply config to ALL endpoints in backend
                .allowedOrigins("http://localhost:5173") // only allow CORS requests from this origin
                .allowedMethods("GET") // defines HTTP methods frontend is allowed to use when making requests
                .allowedHeaders("*") // allows for any Headers the frontend sends
                .allowCredentials(true); //tells browser it's ok to include credentials
    }
}
