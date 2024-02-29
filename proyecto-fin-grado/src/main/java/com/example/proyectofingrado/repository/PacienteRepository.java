package com.example.proyectofingrado.repository;

import com.example.proyectofingrado.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

}
