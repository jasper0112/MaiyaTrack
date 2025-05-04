package com.maiyatrack.config;

import com.maiyatrack.entity.Role;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class RoleConfig extends WebSecurityConfigurerAdapter {
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                // 公共API
                .antMatchers("/api/auth/**").permitAll()
                
                // 用户相关API
                .antMatchers("/api/users/register").permitAll()
                .antMatchers("/api/users/login").permitAll()
                .antMatchers("/api/users/me").authenticated()
                .antMatchers("/api/users/**").hasRole("ADMIN")
                
                // 品牌相关API
                .antMatchers("/api/brands/**").hasAnyRole("USER", "ADMIN")
                
                // 产品相关API
                .antMatchers("/api/products/**").hasAnyRole("USER", "ADMIN")
                
                // 订阅相关API
                .antMatchers("/api/subscriptions/**").hasAnyRole("USER", "ADMIN")
                
                // 通知相关API
                .antMatchers("/api/notifications/**").hasAnyRole("USER", "ADMIN")
                
                // 管理API
                .antMatchers("/api/admin/**").hasRole("ADMIN")
                
                .anyRequest().authenticated()
            .and()
            .csrf().disable()
            .formLogin().disable()
            .httpBasic().disable();
    }
} 