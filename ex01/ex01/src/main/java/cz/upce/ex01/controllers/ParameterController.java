package cz.upce.ex01.controllers;

import cz.upce.ex01.services.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParameterController {
    private final Greeting greetingService;

    public ParameterController(Greeting greetingService) {
        this.greetingService = greetingService;
    }
    @GetMapping("/param")
    public String sayGreeting(){
        return greetingService.sayGreeting();
    }
}
