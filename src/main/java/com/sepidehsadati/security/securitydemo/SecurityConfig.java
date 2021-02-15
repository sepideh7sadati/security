package com.sepidehsadati.security.securitydemo;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable().antMatcher("/**").authorizeRequests()
                .antMatchers("/", "/index.html").authenticated()
                .antMatchers("/home").permitAll()
                .anyRequest().authenticated()
                .and()
                .oauth2Login().permitAll()
                .and().
                logout().logoutSuccessUrl("/");
    }
}
