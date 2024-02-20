package cz.upce.ex01.services;

import org.springframework.stereotype.Service;

@Service
public class Greeting implements  GreetingService{
    @Override
    public String sayGreeting() {
        return "Hello";
    }
}
