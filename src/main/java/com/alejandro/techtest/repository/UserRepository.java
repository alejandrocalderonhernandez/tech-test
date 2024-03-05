package com.alejandro.techtest.repository;

import com.alejandro.techtest.models.entites.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, BigInteger> {

    Optional<UserEntity> findByUsername(String username);
}
