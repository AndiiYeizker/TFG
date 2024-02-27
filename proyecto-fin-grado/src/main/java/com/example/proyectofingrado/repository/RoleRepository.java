package com.example.proyectofingrado.repository;

import com.example.proyectofingrado.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

Role findByName(String name);
}
