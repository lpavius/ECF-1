package com.lucypavius.backend.services;

import com.lucypavius.backend.dtos.UserCreateDto;
import com.lucypavius.backend.dtos.UserDto;
import com.lucypavius.backend.entities.Role;
import com.lucypavius.backend.entities.User;
import com.lucypavius.backend.repositories.RoleRepository;
import com.lucypavius.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void createUser(UserCreateDto dto) {
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setBirthDate(dto.getBirthDate());
        user.setPassword(dto.getPassword());
        Role role = roleRepository.findByDefaultRoleTrue();
        user.setRole(role);
        userRepository.save(user);
    }

    @Override
    public UserDto getById(Long id) {
        User user = userRepository.findById(id).get();
        return convertFrom(user);
    }

    private UserDto convertFrom(User user) {
        UserDto dto = new UserDto();
        dto.setEmail(user.getEmail());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setBirthDate(user.getBirthDate());
        dto.setPassword(user.getPassword());
        return dto;
    }
}
