package com.example.ex02.controller;

import com.example.ex02.entities.AppUser;
import com.example.ex02.entities.User;
import com.example.ex02.services.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class AppUserController {
    private final AppUserService service;
    @GetMapping("/users/{id}")
    public List<AppUser> getAppUsersByRole(@PathVariable int id){
        return service.getAll(id);
    }
}
