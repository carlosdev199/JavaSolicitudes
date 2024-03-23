package com.semillero.solicitudes.controller;

import com.semillero.solicitudes.model.Empleado;
import com.semillero.solicitudes.service.EmpleadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {
    private final EmpleadoService empleadoService;
    // Constructor que inyecta el servicio EmpleadoService
    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }
    // Endpoint para crear un nuevo empleado
    @PostMapping
    public ResponseEntity<Empleado> createEmpleado(@RequestBody Empleado empleado) {
        Empleado savedEmpleado = empleadoService.save(empleado);
        return new ResponseEntity<>(savedEmpleado, HttpStatus.CREATED);
    }
    // Endpoint para obtener todos los empleados
    @GetMapping
    public ResponseEntity<List<Empleado>> getAllEmpleados() {
        List<Empleado> empleados = empleadoService.findAll();
        return new ResponseEntity<>(empleados, HttpStatus.OK);
    }
    // Endpoint para obtener un empleado por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Empleado> getEmpleadoById(@PathVariable Integer id) {
        Empleado empleado = empleadoService.findById(id);
        if (empleado != null) {
            return new ResponseEntity<>(empleado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    // Endpoint para actualizar un empleado existente
    @PutMapping("/{id}")
    public ResponseEntity<Empleado> updateEmpleado(@PathVariable Integer id, @RequestBody Empleado empleadoDetails) {
        Empleado existingEmpleado = empleadoService.findById(id);
        if (existingEmpleado != null) {
            empleadoDetails.setIdEmpleado(id);
            Empleado updatedEmpleado = empleadoService.update(empleadoDetails);
            return new ResponseEntity<>(updatedEmpleado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    // Endpoint para eliminar un empleado por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmpleado(@PathVariable Integer id) {
        Empleado empleado = empleadoService.findById(id);
        if (empleado != null) {
            empleadoService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
