package com.example.ex02.controller;

import com.example.ex02.dto.AppUserDto;
import com.example.ex02.dto.AppUserInputDto;
import com.example.ex02.entities.AppUser;
import com.example.ex02.services.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/app-user")
public class AppUserController {
    private final AppUserService service;

    @GetMapping("")
    public ResponseEntity<List<AppUserDto>> findAll(){
        var result = service.findAll();
        return ResponseEntity.ok(result.stream().map(AppUser::toDto).collect(Collectors.toList()));
    }
    @GetMapping("/active/{active}")
    public ResponseEntity<List<AppUserDto>> findByActive(@PathVariable final Boolean active){
        var result = service.findAllByActiveEquals(active);
        return ResponseEntity.ok(result.stream().map(AppUser::toDto).collect(Collectors.toList()));
    }

    @GetMapping("/role/{role}")
    public ResponseEntity<List<AppUserDto>> findByRole(@PathVariable final String role){
        var result = service.findByRole(role);
        return ResponseEntity.ok(result.stream().map(AppUser::toDto).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable final Long id){
        var result = service.findById(id);
        return ResponseEntity.ok(result.toDto());
    }
    @PostMapping("")
    public ResponseEntity<AppUserDto> create(@RequestBody @Validated final AppUserInputDto request){
        var result = service.create(toEntity(request));
        return ResponseEntity.ok(result.toDto());
    }
    @PutMapping("/{id}")
    public ResponseEntity<AppUserDto> update(@RequestBody final AppUserInputDto request, @PathVariable final Long id){
        var result = service.update(toEntity(id, request));
        return ResponseEntity.ok(result.toDto());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable final Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private static AppUser toEntity(final AppUserInputDto input){
        return new AppUser(input.getUsername(), input.getPassword(), input.getActive());
    }
    private static AppUser toEntity(final Long id, final  AppUserInputDto input){
        return new AppUser(id, input.getUsername(), input.getPassword(), input.getActive());
    }
}
