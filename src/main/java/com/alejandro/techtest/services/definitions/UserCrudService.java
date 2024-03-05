package com.alejandro.techtest.services.definitions;

import com.alejandro.techtest.models.dtos.UserDto;

import java.math.BigInteger;

public interface UserCrudService {

    UserDto read(BigInteger id);
    UserDto create(UserDto userDto);
    UserDto update(UserDto userDto, BigInteger id);
    void delete(BigInteger id);
}
