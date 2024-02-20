package com.example.ex02.services;

import com.example.ex02.entities.User;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;

@Service
public class UserService implements IUserService{
    private HashMap<Long, User> users;
    public UserService(){
        users = new HashMap<>();
        users.put(0L, new User(0, "Jarda", "Jagr"));
        users.put(1L, new User(1, "Tomáš", "Plekanec"));
        users.put(2L, new User(2, "Martin", "Hejduk"));
    }

    @Override
    public Collection<User> getAll() {
        return users.values();
    }

    @Override
    public User getUser(long id) {
        return users.get(id);
    }
}
