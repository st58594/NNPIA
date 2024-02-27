package com.example.ex02.services;

import com.example.ex02.entities.AppUser;
import com.example.ex02.entities.Role;
import com.example.ex02.entities.User;
import com.example.ex02.repositories.AppUserReposity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AppUserService {
    private final AppUserReposity reposity;
    public List<AppUser> getAll(int role){
        return reposity.findAllByRoles(role);
    }
}
