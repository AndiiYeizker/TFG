package com.example.proyectofingrado.repository;

import com.example.proyectofingrado.entity.Enfermedad;
import com.example.proyectofingrado.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnfermedadRepository extends JpaRepository<Enfermedad, Long> {
}
