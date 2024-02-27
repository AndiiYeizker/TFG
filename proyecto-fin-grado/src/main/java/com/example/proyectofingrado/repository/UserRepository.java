package com.example.proyectofingrado.repository;

import com.example.proyectofingrado.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
User findByEmail(String email);

}
