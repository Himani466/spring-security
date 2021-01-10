package com.example.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("himani").password(passwordEncoder().encode("himani123"))
                .roles("ADMIN").authorities("ACCESS_TEST1")
                .and()
                .withUser("shivani").password(passwordEncoder().encode("shivani123"))
                .roles("USER").authorities("ACCESS_TEST2");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       /* http
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .httpBasic();*/
       /* http
                .authorizeRequests()
                .antMatchers("/api/public/api1").permitAll()
                .antMatchers("/api/public/api2").authenticated()
                .antMatchers("/api/public/api3").hasRole("ADMIN")
                .antMatchers("/api/public/api4").hasAnyRole("ADMIN", "USER")
                .and()
                .httpBasic();
        */
        http
                .authorizeRequests()
                .antMatchers("/api/public/api1").hasAuthority("ACCESS_TEST1")
                .antMatchers("/api/public/api2").hasAuthority("ACCESS_TEST2")
                .antMatchers("/api/public/api3").hasAnyAuthority("ACCESS_TEST1", "ACCESS_TEST2")
                .and()
                .httpBasic();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
