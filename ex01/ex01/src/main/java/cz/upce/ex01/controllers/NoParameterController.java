package cz.upce.ex01.controllers;

import cz.upce.ex01.services.Greeting;
import cz.upce.ex01.services.GreetingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoParameterController {

    private final GreetingService greetingService;

    public NoParameterController() {
        this.greetingService = new Greeting();
    }

    @GetMapping("/noparam")
    public String getGreeting(){
        return greetingService.sayGreeting();
    }
}
