package com.example.ex02.controller;

import org.springframework.web.bind.annotation.*;

//@RestController = @Controller + @ResponseBody -> return JSON; @Controller může obecně vracet view -> return HTML
// YAML: mezery, odřádkování JSON: závorky XML: tagy
@RestController
public class HelloController {
    @GetMapping("")
    public String helloWorld(){
        return "Hello world.";
    }

    @GetMapping("/hello/{name}")
    public String helloMe(@PathVariable String name){
        return "Hello " + name;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/hello")
    public String helloQuery(@RequestParam("name") String name){
        return "Hello" + name;
    }


}
