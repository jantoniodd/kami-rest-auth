package com.jadd.kamirestauth.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.jadd.kamirestauth.entities.UserEntity;

import reactor.core.publisher.Mono;

@Repository
public interface UserEntityRepository extends ReactiveMongoRepository<UserEntity, String> {

    Mono<Boolean> existsByUsername(String username);

}
