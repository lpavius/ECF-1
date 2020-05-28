package com.lucypavius.backend.controllers;

import com.lucypavius.backend.dtos.UserCreateDto;
import com.lucypavius.backend.dtos.UserDto;
import com.lucypavius.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RequestMapping
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /* Create */
    @PostMapping("/user")
    public void create(@Valid @RequestBody UserCreateDto dto) {
        userService.createUser(dto);
    }

    /* Read */
    @GetMapping("/user/{id}")
    public UserDto get(@PathVariable("id") Long id) {
        return userService.getById(id);
    }

    /* Update */
    /* Delete */
}
