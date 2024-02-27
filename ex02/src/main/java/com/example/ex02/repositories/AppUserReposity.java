package com.example.ex02.repositories;

import com.example.ex02.entities.AppUser;
import com.example.ex02.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppUserReposity extends JpaRepository<AppUser, Integer> {
    @Query(value = "select * from app_user u " +
            "join app_user_role aur on u.id = aur.app_user_id " +
            "where role_id = ?1", nativeQuery = true)
    List<AppUser> findAllByRoles(int role);
}
