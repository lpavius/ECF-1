package com.lucypavius.backend.repositories;

import com.lucypavius.backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    //
}
