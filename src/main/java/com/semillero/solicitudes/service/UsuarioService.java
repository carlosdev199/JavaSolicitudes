package com.semillero.solicitudes.service;

import com.semillero.solicitudes.model.Usuario;

import java.util.List;

public interface UsuarioService {
    Usuario save(Usuario usuario);
    List<Usuario> findAll();
    Usuario findById(Integer id);
    void deleteById(Integer id);
    Usuario update(Usuario cargo);

}

