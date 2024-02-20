package com.example.ex02.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class User {
    private long id;
    private String firstName;
    private String lastName;
}
