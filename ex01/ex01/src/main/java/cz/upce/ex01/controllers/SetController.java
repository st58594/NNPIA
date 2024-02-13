package cz.upce.ex01.controllers;

import cz.upce.ex01.services.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SetController {
    private Greeting greetingService;

    public SetController(Greeting greetingService) {
        setGreetingService(greetingService);
    }
    public void setGreetingService(@Autowired Greeting greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/set")
    public String sayGreeting(){
        return greetingService.sayGreeting();
    }
}
