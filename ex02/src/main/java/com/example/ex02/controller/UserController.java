package com.example.ex02.controller;

import com.example.ex02.entities.User;
import com.example.ex02.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
@RestController
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/user")
    public Collection<User> getAll(){
        return userService.getAll();
    }
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable long id){
        return userService.getUser(id);
    }
}
