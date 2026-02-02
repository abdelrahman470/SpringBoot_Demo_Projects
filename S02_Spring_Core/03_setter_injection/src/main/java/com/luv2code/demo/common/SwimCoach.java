package com.luv2code.demo.common;

public class SwimCoach implements Coach{

    public SwimCoach(){
        System.out.println(getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "swim 1000 m now !!!";
    }
}
