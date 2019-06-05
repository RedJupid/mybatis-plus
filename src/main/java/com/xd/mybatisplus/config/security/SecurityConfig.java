//package com.xd.mybatisplus.config.security;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                .httpBasic().authenticationEntryPoint(new MyAuthenticationEntryPoint())
//                .and()
//                .authorizeRequests()
//                .antMatchers("/swagger-ui.html",
//                        "/swagger-resources/**",
//                        "/v2/api-docs",
//                        "/login").permitAll()
//        .anyRequest()
//        .authenticated();
//
//
//    }
//}
