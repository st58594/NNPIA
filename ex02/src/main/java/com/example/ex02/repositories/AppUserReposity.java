package com.example.ex02.repositories;

import com.example.ex02.entities.AppUser;
import com.example.ex02.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppUserReposity extends JpaRepository<AppUser, Long> {
    @Query(value = "SELECT au.* FROM app_user au " +
            "JOIN app_user_role aur ON au.id = aur.app_user_id " +
            "JOIN role r ON aur.role_id = r.id WHERE r.role = :role", nativeQuery = true)
    List<AppUser> findByRole(String role);
    List<AppUser> findAllByActiveEquals(boolean active);
}
