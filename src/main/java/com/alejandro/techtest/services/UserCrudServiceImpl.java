package com.alejandro.techtest.services;

import com.alejandro.techtest.models.dtos.UserDto;
import com.alejandro.techtest.models.entites.UserEntity;
import com.alejandro.techtest.repository.UserRepository;
import com.alejandro.techtest.services.definitions.UserCrudService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
@Transactional
@Service
public class UserCrudServiceImpl implements UserCrudService {

    private final UserRepository userRepository;

    @Override
    public UserDto read(BigInteger id) {
        return this.userRepository.findById(id)
                .map(this::toUserDto)
                .orElseThrow(() -> new NoSuchElementException("User not found"));
    }

    @Override
    public UserDto create(UserDto userDto) {
        final var userEntity = this.toUserEntity(userDto);
        final var userUpdated = this.userRepository.save(userEntity);

        return this.toUserDto(userUpdated);
    }

    @Override
    public UserDto update(UserDto userDto, BigInteger id) {
        final var userToUpdate = this.userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found"));

        userToUpdate.setAddress(userDto.getAddress());
        userToUpdate.setEmail(userDto.getEmail());
        userToUpdate.setRole(userToUpdate.getRole());

        var userUpdated = this.userRepository.save(userToUpdate);
        return this.toUserDto(userUpdated);
    }

    @Override
    public void delete(BigInteger id) {
        final var userToUpdate = this.userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found"));

        this.userRepository.deleteById(userToUpdate.getId());
    }


    private UserDto toUserDto(UserEntity userEntity) {
        return UserDto
                .builder()
                    .id(userEntity.getId())
                    .email(userEntity.getEmail())
                    .username(userEntity.getUsername())
                    .address(userEntity.getAddress())
                    .role(userEntity.getRole())
                .build();
    }

    private UserEntity toUserEntity(UserDto userDto) {
        return (Objects.isNull(userDto.getId())) ? UserEntity
                .builder()
                    .email(userDto.getEmail())
                   .password(UUID.randomUUID().toString())
                    .username(userDto.getUsername())
                    .address(userDto.getAddress())
                    .role(userDto.getRole())
                .build() : UserEntity
                .builder()
                    .id(userDto.getId())
                    .email(userDto.getEmail())
                    .username(userDto.getUsername())
                    .address(userDto.getAddress())
                    .role(userDto.getRole())
                .build();
    }
}
