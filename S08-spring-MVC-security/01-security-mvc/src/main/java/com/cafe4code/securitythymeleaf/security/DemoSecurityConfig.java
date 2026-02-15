package com.cafe4code.securitythymeleaf.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

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
}
