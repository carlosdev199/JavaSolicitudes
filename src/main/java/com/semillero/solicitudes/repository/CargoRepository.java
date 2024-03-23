package com.semillero.solicitudes.repository;

import com.semillero.solicitudes.model.Alerta;
import com.semillero.solicitudes.model.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoRepository extends JpaRepository<Cargo, Integer> {

}
