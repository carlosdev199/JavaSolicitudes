package com.semillero.solicitudes.controller;

import com.semillero.solicitudes.model.Usuario;
import com.semillero.solicitudes.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;
    // Constructor que inyecta el servicio UsuarioService
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    // Endpoint para crear un nuevo usuario
    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {
        Usuario savedUsuario = usuarioService.save(usuario);
        return new ResponseEntity<>(savedUsuario, HttpStatus.CREATED);
    }
    // Endpoint para obtener todos los usuarios
    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        List<Usuario> usuarios = usuarioService.findAll();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }
    // Endpoint para obtener un usuario por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Integer id) {
        Usuario usuario = usuarioService.findById(id);
        if (usuario != null) {
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    // Endpoint para actualizar un usuario existente
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Integer id, @RequestBody Usuario usuarioDetails) {
        Usuario existingUsuario = usuarioService.findById(id);
        if (existingUsuario != null) {
            usuarioDetails.setIdUsuario(id);
            Usuario updatedUsuario = usuarioService.update(usuarioDetails);
            return new ResponseEntity<>(updatedUsuario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    // Endpoint para eliminar un usuario por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Integer id) {
        Usuario usuario = usuarioService.findById(id);
        if (usuario != null) {
            usuarioService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}


