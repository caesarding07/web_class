package com.example.web_class.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName: CrossOriginConfig
 * @Description: 跨域crosorigin配置
 * @Author CaesarDing
 * @Date 2020/11/17
 * @Version 1.0.0
 */
@Configuration
public class CrossOriginConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry corsRegistry){
        corsRegistry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET","HEAD","PUT","DELETE","OPTIONS")
                .allowCredentials(true)
                .maxAge(3600)
                .allowedHeaders("*");
    }
}
