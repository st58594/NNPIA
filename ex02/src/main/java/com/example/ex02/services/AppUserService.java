package com.example.ex02.services;

import com.example.ex02.entities.AppUser;
import com.example.ex02.exceptions.ResourceNotFoundException;
import com.example.ex02.repositories.AppUserReposity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class AppUserService {
    private final AppUserReposity reposity;
    @Transactional
    public AppUser findById(final Long id) throws ResourceNotFoundException{
        return reposity.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @Transactional
    public AppUser create(final AppUser appUser) {
        return reposity.save(appUser);
    }

    @Transactional
    public AppUser update(final AppUser appUser) {
        return reposity.save(appUser);
    }

    @Transactional
    public void delete(final Long id) {
        reposity.deleteById(id);
    }

    public List<AppUser> findByRole(final String role) {
        return reposity.findByRole(role);
    }

    public List<AppUser> findAllByActiveEquals(final Boolean active) {
        return reposity.findAllByActiveEquals(active);
    }

    public List<AppUser> findAll() {
        return reposity.findAll();
    }
}
