package com.cafe4code.securitythymeleaf.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

    // add support for JDBC (password is fun123)
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){

        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);

        userDetailsManager
                .setUsersByUsernameQuery("select user_id, pw, active from members where user_id=?");

        userDetailsManager
                .setAuthoritiesByUsernameQuery("select user_id, role from roles where user_id=?");

        return userDetailsManager;
    }

    // custom login form & access-denied pages
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers("/").hasRole("EMPLOYEE")
                        .requestMatchers("/leaders/**").hasRole("MANAGER")
                        .requestMatchers("/systems/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )

                .exceptionHandling(access ->
                        access
                                .accessDeniedPage("/access-denied")
                )

                .formLogin(form ->
                        form.loginPage("/showMyLoginPage")
                                .loginProcessingUrl("/authenticateTheUser")
                                .permitAll()
                )
                .logout(logout -> logout.permitAll()
        );

        return http.build();
    }


    /*
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails emma = User.builder()
                .username("emma")
                .password("{noop}t1")
                .roles("EMPLOYEE")
                .build();

        UserDetails rick = User.builder()
                .username("rick")
                .password("{noop}t1")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        UserDetails abdo = User.builder()
                .username("abdo")
                .password("{noop}t1")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(emma, abdo, rick);
    }
    */
}
