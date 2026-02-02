package com.luv2code.demo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class TrackCoach implements Coach {

    public TrackCoach(){
        System.out.println(getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "run 15 km ! (track coach)";
    }
}
