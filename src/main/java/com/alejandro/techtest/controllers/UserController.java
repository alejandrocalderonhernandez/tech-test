package com.alejandro.techtest.controllers;

import com.alejandro.techtest.models.dtos.UserDto;
import com.alejandro.techtest.services.definitions.UserCrudService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.net.URI;

@AllArgsConstructor
@RestController
@RequestMapping(path = "crud-user")
public class UserController {

    private UserCrudService userService;

    @GetMapping(path = "{id}")
    public ResponseEntity<UserDto> get(@PathVariable BigInteger id) {
        return ResponseEntity.ok(this.userService.read(id));
    }

    @PostMapping
    public ResponseEntity<UserDto> post(@RequestBody UserDto user) {
        return ResponseEntity.created(URI.create(
                this.userService.create(user).getUsername())).build();
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<UserDto> post(
            @RequestBody UserDto user,
            @PathVariable BigInteger id) {
        return ResponseEntity.ok(this.userService.update(user, id));

    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> delete(@PathVariable BigInteger id) {
        this.userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
