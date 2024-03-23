package com.semillero.solicitudes.service;

import com.semillero.solicitudes.model.Empleado;
import com.semillero.solicitudes.model.RolUsuario;

import java.util.List;

public interface RolUsuarioService {
    RolUsuario save(RolUsuario rolUsuario);
    List<RolUsuario> findAll();
    RolUsuario findById(Integer id);
    void deleteById(Integer id);
    RolUsuario update(RolUsuario rolUsuario);
}
