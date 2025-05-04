package com.maiyatrack.config;

import com.maiyatrack.entity.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class RoleConfig {
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                // 公共API
                .requestMatchers("/api/auth/**").permitAll()
                
                // 用户相关API
                .requestMatchers("/api/users/register").permitAll()
                .requestMatchers("/api/users/login").permitAll()
                .requestMatchers("/api/users/me").authenticated()
                .requestMatchers("/api/users/**").hasRole("ADMIN")
                
                // 品牌相关API
                .requestMatchers("/api/brands/**").hasAnyRole("USER", "ADMIN")
                
                // 产品相关API
                .requestMatchers("/api/products/**").hasAnyRole("USER", "ADMIN")
                
                // 订阅相关API
                .requestMatchers("/api/subscriptions/**").hasAnyRole("USER", "ADMIN")
                
                // 通知相关API
                .requestMatchers("/api/notifications/**").hasAnyRole("USER", "ADMIN")
                
                // 管理API
                .requestMatchers("/api/admin/**").hasRole("ADMIN")
                
                .anyRequest().authenticated()
            )
            .csrf(csrf -> csrf.disable())
            .formLogin(form -> form.disable())
            .httpBasic(httpBasic -> httpBasic.disable());
            
        return http.build();
    }
} 