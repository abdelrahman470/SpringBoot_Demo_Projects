package com.luv2code.demo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

    public TennisCoach(){
        System.out.println(getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "train your arm well ! (tennis coach)";
    }
}
