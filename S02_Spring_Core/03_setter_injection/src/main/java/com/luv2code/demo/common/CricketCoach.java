package com.luv2code.demo.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    public CricketCoach(){
        System.out.println(getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {

        return "hit the ball hard and far ! (cricket coach)";
    }
}
