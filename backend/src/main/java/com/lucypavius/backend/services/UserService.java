package com.lucypavius.backend.services;

import com.lucypavius.backend.dtos.UserCreateDto;
import com.lucypavius.backend.dtos.UserDto;
import com.lucypavius.backend.entities.User;

import java.util.List;

public interface UserService {

    void createUser(UserCreateDto dto);

    UserDto getById(Long id);
}
