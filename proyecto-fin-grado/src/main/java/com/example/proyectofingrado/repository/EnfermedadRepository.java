package com.example.proyectofingrado.repository;

import com.example.proyectofingrado.entity.Enfermedad;
import com.example.proyectofingrado.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnfermedadRepository extends JpaRepository<Enfermedad, Long> {
    @Query("SELECT e.nombre FROM Enfermedad e")
    List<String> findAllNombres();
}
