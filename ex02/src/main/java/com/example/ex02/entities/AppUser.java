package com.example.ex02.entities;

import com.example.ex02.dto.AppUserDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
// create-drop, create, validate, update, none

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "app_user")
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String username;
    @Column
    private String password;
    @Column
    private boolean active;
    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime created;
    @Column
    @UpdateTimestamp
    private LocalDateTime updated;

    @ManyToMany
    @JoinTable(
            name = "app_user_role",
            joinColumns = @JoinColumn(name = "app_user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles = Collections.emptyList();

    public AppUser(String username, String password, Boolean active) {
        this.username = username;
        this.password = password;
        this.created = LocalDateTime.now();
        this.updated = LocalDateTime.now();
        this.active = active;
    }

    public AppUser(Long id, String username, String password, Boolean active) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.created = LocalDateTime.now();
        this.updated = LocalDateTime.now();
        this.active = active;
    }


    public AppUserDto toDto(){
        return new AppUserDto(id, username, password, active, created, updated, roles);
    }
}
