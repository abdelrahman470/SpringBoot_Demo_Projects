package com.luv2code.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    // injection
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    // expose endpoint
    @GetMapping("/teaminfo")
    public String getTeamInfo(){
        return "coach: " + coachName + " team: " + teamName;
    }

    @GetMapping("/")
    public String sayHello(){
        return "Hello spring !";
    }

    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Run 5k !";
    }
}
