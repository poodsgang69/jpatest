package com.test.jpatest.controller;

import com.test.jpatest.serivce.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UdemyController {

    private Coach controllerCoach;

    @Autowired
    public UdemyController (Coach coach) {
        this.controllerCoach = coach;
    }

    @Value("${team.name}")
    private String Org;

    @Value("${player.name}")
    private String MVP;

    @GetMapping("/hello")
    public String HelloWorld() {
        return "Hello World!";
    }

    @GetMapping("/best")
    public String BestPlayer() {
        return "The Best player from " + Org + " is: " + MVP;
    }

    @GetMapping("/cricket")
    public String getCricketTraining() {
        return controllerCoach.getTrainingSchedule();
    }
}
