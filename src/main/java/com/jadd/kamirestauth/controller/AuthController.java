package com.jadd.kamirestauth.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jadd.kamirestauth.dtos.CreateUserDto;
import com.jadd.kamirestauth.entities.UserEntity;
import com.jadd.kamirestauth.services.UserEntityService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private UserEntityService service;

    public AuthController(UserEntityService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public Mono<UserEntity> createUser(@Validated @RequestBody CreateUserDto dto) {
    
        return this.service.createUser(dto);

    }
}
