package com.semillero.solicitudes.controller;

import com.semillero.solicitudes.model.Alerta;
import com.semillero.solicitudes.service.AlertaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alertas")
public class AlertaController {

    private final AlertaService alertaService;
    // Constructor para inyectar el servicio AlertaService
    public AlertaController(AlertaService alertaService) {
        this.alertaService = alertaService;
    }
    // Endpoint para crear una nueva alerta
    @PostMapping
    public ResponseEntity<Alerta> createAlerta(@RequestBody Alerta alerta) {
        Alerta savedAlerta = alertaService.save(alerta);
        return new ResponseEntity<>(savedAlerta, HttpStatus.CREATED);
    }
    // Endpoint para obtener todas las alertas
    @GetMapping
    public ResponseEntity<List<Alerta>> getAllAlertas() {
        List<Alerta> alertas = alertaService.findAll();
        return new ResponseEntity<>(alertas, HttpStatus.OK);
    }
    // Endpoint para obtener una alerta por su ID

    @GetMapping("/{id}")
    public ResponseEntity<Alerta> getAlertaById(@PathVariable Integer id) {
        Alerta alerta = alertaService.findById(id);
        if (alerta != null) {
            return new ResponseEntity<>(alerta, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    // Endpoint para actualizar una alerta existente
    @PutMapping("/{id}")
    public ResponseEntity<Alerta> updateAlerta(@PathVariable Integer id, @RequestBody Alerta alertaDetails) {
        Alerta existingAlerta = alertaService.findById(id);
        if (existingAlerta != null) {
            alertaDetails.setIdAlerta(id);
            Alerta updatedAlerta = alertaService.update(alertaDetails);
            return new ResponseEntity<>(updatedAlerta, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    // Endpoint para eliminar una alerta por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlerta(@PathVariable Integer id) {
        Alerta alerta = alertaService.findById(id);
        if (alerta != null) {
            alertaService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
