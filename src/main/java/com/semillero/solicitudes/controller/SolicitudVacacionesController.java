package com.semillero.solicitudes.controller;

import com.semillero.solicitudes.model.SolicitudVacaciones;
import com.semillero.solicitudes.service.SolicitudVacacionesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/solicitudes-vacaciones")
public class SolicitudVacacionesController {

    private final SolicitudVacacionesService solicitudVacacionesService;

    // Constructor que inyecta el servicio SolicitudVacacionesService
    public SolicitudVacacionesController(SolicitudVacacionesService solicitudVacacionesService) {
        this.solicitudVacacionesService = solicitudVacacionesService;
    }
    // Endpoint para crear una nueva solicitud de vacaciones
    @PostMapping
    public ResponseEntity<SolicitudVacaciones> createSolicitudVacaciones(@RequestBody SolicitudVacaciones solicitudVacaciones)
    {
        SolicitudVacaciones savedSolicitudVacaciones = solicitudVacacionesService.save(solicitudVacaciones);
        return new ResponseEntity<>(savedSolicitudVacaciones, HttpStatus.CREATED);
    }
    // Endpoint para obtener todas las solicitudes de vacaciones
    @GetMapping
    public ResponseEntity<List<SolicitudVacaciones>> getAllSolicitudesVacaciones() {
        List<SolicitudVacaciones> solicitudesVacaciones = solicitudVacacionesService.findAll();
        return new ResponseEntity<>(solicitudesVacaciones, HttpStatus.OK);
    }
    // Endpoint para obtener una solicitud de vacaciones por su ID
    @GetMapping("/{id}")
    public ResponseEntity<SolicitudVacaciones> getSolicitudVacacionesById(@PathVariable Integer id) {
        SolicitudVacaciones solicitudVacaciones = solicitudVacacionesService.findById(id);
        if (solicitudVacaciones != null) {
            return new ResponseEntity<>(solicitudVacaciones, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    // Endpoint para actualizar una solicitud de vacaciones existente
    @PutMapping("/{id}")
    public ResponseEntity<SolicitudVacaciones> updateSolicitudVacaciones(@PathVariable Integer id, @RequestBody SolicitudVacaciones solicitudVacacionesDetails) {
        SolicitudVacaciones existingSolicitudVacaciones = solicitudVacacionesService.findById(id);
        if (existingSolicitudVacaciones != null) {
            solicitudVacacionesDetails.setIdSolicitud(id);
            SolicitudVacaciones updatedSolicitudVacaciones = solicitudVacacionesService.update(solicitudVacacionesDetails);
            return new ResponseEntity<>(updatedSolicitudVacaciones, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    // Endpoint para eliminar una solicitud de vacaciones por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSolicitudVacaciones(@PathVariable Integer id) {
        SolicitudVacaciones solicitudVacaciones = solicitudVacacionesService.findById(id);
        if (solicitudVacaciones != null) {
            solicitudVacacionesService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
