package com.alejandro.techtest.models.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    private BigInteger id;
    private String username;
    private String password;
    private String email;
    private String address;
    @JsonProperty(value = "user_role")
    private String role;

}
