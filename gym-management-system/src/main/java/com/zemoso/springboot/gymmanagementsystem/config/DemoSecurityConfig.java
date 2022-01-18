package com.zemoso.springboot.gymmanagementsystem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String CUSTOMER = "CUSTOMER";
    private static final String TRAINER = "TRAINER";

    @Autowired
    @Qualifier("securityDataSource")
    private DataSource securityDataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication().dataSource(securityDataSource);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().
                antMatchers("/trainers/home").hasRole(TRAINER).
                antMatchers("/customers/home").hasRole(CUSTOMER).
                antMatchers("/resources/**").permitAll().
                and().
                formLogin().
                loginPage("/show-login-page").
                defaultSuccessUrl("/home").
                loginProcessingUrl("/authenticateTheUser").
                permitAll().
                and().
                logout().
                permitAll().
                and().
                exceptionHandling().
                accessDeniedPage("/access-denied");
    }


}
