package com.example.ex02.services;

import com.example.ex02.entities.User;

import java.util.Collection;
import java.util.HashMap;

public interface IUserService {
    Collection<User> getAll();
    User getUser(long id);
}
