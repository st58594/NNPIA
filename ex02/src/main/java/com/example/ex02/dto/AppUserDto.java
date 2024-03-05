package com.example.ex02.dto;

import com.example.ex02.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUserDto {
    private Long id;
    private String username;
    private String password;
    private Boolean active;
    private LocalDateTime created;
    private LocalDateTime updated;
    private List<Role> roles = Collections.emptyList();
}
