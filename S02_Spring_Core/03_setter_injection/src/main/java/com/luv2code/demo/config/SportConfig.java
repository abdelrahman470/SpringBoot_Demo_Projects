package com.luv2code.demo.config;

import com.luv2code.demo.common.Coach;
import com.luv2code.demo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aqua")
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
