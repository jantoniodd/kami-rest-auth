package com.jadd.kamirestauth.services;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.jadd.kamirestauth.dtos.CreateUserDto;
import com.jadd.kamirestauth.entities.UserEntity;
import com.jadd.kamirestauth.enums.RoleEnum;
import com.jadd.kamirestauth.repositories.UserEntityRepository;

import reactor.core.publisher.Mono;

@Service
public class UserEntityService {

    private UserEntityRepository repository;

    public UserEntityService(UserEntityRepository repository) {
        this.repository = repository;
    }

    public Mono<UserEntity> createUser(CreateUserDto dto) {

        repository.existsByUsername(dto.getUsername()).map(u -> Mono.error(new Throwable("Usuario existe")));

        UserEntity user = new UserEntity();

        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setRoles(
                dto.getRoles().stream().map(r -> RoleEnum.valueOf(r)).collect(Collectors.toList()));

        return repository.save(user);

    }

}
