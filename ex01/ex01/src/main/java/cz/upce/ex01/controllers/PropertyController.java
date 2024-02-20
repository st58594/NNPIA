package cz.upce.ex01.controllers;

import cz.upce.ex01.services.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PropertyController {
    @Autowired
    Greeting greetingService;
    @GetMapping("/property")
    public String sayGreeting(){
        return greetingService.sayGreeting();
    }
}
