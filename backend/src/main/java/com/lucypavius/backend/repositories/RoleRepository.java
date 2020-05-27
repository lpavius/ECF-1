package com.lucypavius.backend.repositories;

import com.lucypavius.backend.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByDefaultRoleTrue();
}
