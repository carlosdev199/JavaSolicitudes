package com.semillero.solicitudes.controller;

import com.semillero.solicitudes.model.RolUsuario;
import com.semillero.solicitudes.service.RolUsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles-usuarios")
public class RolUsuarioController {

    private final RolUsuarioService rolUsuarioService;
    // Constructor que inyecta el servicio RolUsuarioService
    public RolUsuarioController(RolUsuarioService rolUsuarioService) {
        this.rolUsuarioService = rolUsuarioService;
    }
    // Endpoint para crear un nuevo rol de usuario
    @PostMapping
    public ResponseEntity<RolUsuario> createRolUsuario(@RequestBody RolUsuario rolUsuario) {
        RolUsuario savedRolUsuario = rolUsuarioService.save(rolUsuario);
        return new ResponseEntity<>(savedRolUsuario, HttpStatus.CREATED);
    }
    // Endpoint para obtener todos los roles de usuarios
    @GetMapping
    public ResponseEntity<List<RolUsuario>> getAllRolesUsuarios() {
        List<RolUsuario> rolesUsuarios = rolUsuarioService.findAll();
        return new ResponseEntity<>(rolesUsuarios, HttpStatus.OK);
    }
    // Endpoint para obtener un rol de usuario por su ID
    @GetMapping("/{id}")
    public ResponseEntity<RolUsuario> getRolUsuarioById(@PathVariable Integer id) {
        RolUsuario rolUsuario = rolUsuarioService.findById(id);
        if (rolUsuario != null) {
            return new ResponseEntity<>(rolUsuario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    // Endpoint para actualizar un rol de usuario existente
    @PutMapping("/{id}")
    public ResponseEntity<RolUsuario> updateRolUsuario(@PathVariable Integer id, @RequestBody RolUsuario rolUsuarioDetails) {
        RolUsuario existingRolUsuario = rolUsuarioService.findById(id);
        if (existingRolUsuario != null) {
            rolUsuarioDetails.setIdRol(id);
            RolUsuario updatedRolUsuario = rolUsuarioService.update(rolUsuarioDetails);
            return new ResponseEntity<>(updatedRolUsuario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
// Endpoint para eliminar un rol de usuario por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRolUsuario(@PathVariable Integer id) {
        RolUsuario rolUsuario = rolUsuarioService.findById(id);
        if (rolUsuario != null) {
            rolUsuarioService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
