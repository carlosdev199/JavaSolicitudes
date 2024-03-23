package com.semillero.solicitudes.repository;

import com.semillero.solicitudes.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
