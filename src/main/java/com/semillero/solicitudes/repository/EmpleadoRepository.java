package com.semillero.solicitudes.repository;

import com.semillero.solicitudes.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
}
