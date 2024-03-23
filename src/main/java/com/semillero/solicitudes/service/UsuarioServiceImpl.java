package com.semillero.solicitudes.service;

import com.semillero.solicitudes.model.Empleado;
import com.semillero.solicitudes.model.Usuario;
import com.semillero.solicitudes.repository.EmpleadoRepository;
import com.semillero.solicitudes.repository.UsuarioRepository;

import java.util.List;

public class UsuarioServiceImpl implements UsuarioService{
    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> findAll() {
        return null;
    }

    @Override
    public Usuario findById(Integer id) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Usuario update(Usuario usuario) {
        return null;
    }
}
