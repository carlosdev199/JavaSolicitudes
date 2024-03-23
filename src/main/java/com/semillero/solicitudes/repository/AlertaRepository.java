package com.semillero.solicitudes.repository;

import com.semillero.solicitudes.model.Alerta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertaRepository extends JpaRepository<Alerta, Integer> {
}
