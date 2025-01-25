package com.example.loginproject.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class MyCorsConfig {
    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("http://localhost:8081");    // 允许谁跨域
        configuration.setAllowCredentials(true);                    // 传cookie
        configuration.addAllowedMethod("*");                        // 允许哪些方法跨域 post/get
        configuration.addAllowedHeader("*");                        // 允许哪些头信息

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration); // 拦截一切请求

        return new CorsFilter(source);
    }
}
