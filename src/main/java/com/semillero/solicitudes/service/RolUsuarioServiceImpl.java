package com.semillero.solicitudes.service;


import com.semillero.solicitudes.model.RolUsuario;
import com.semillero.solicitudes.repository.RolUsuarioRespository;

import java.util.List;

public class RolUsuarioServiceImpl implements RolUsuarioService {
    private final RolUsuarioRespository rolUsuarioRespository;

    public RolUsuarioServiceImpl(RolUsuarioRespository rolUsuarioRespository) {
        this.rolUsuarioRespository = rolUsuarioRespository;
    }

    @Override
    public RolUsuario save(RolUsuario rolUsuario) {
        return rolUsuarioRespository.save(rolUsuario);
    }

    @Override
    public List<RolUsuario> findAll() {
        return null;
    }

    @Override
    public RolUsuario findById(Integer id) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public RolUsuario update(RolUsuario rolUsuario) {
        return null;
    }
}
