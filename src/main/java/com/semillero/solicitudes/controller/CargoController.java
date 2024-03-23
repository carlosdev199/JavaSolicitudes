package com.semillero.solicitudes.controller;

import com.semillero.solicitudes.model.Cargo;
import com.semillero.solicitudes.service.CargoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cargos")
public class CargoController {

    private final CargoService cargoService;
    // Constructor que inyecta el servicio CargoService
    public CargoController(CargoService cargoService) {
        this.cargoService = cargoService;
    }
    // Endpoint para crear una nuevo cargo
    @PostMapping
    public ResponseEntity<Cargo> createCargo(@RequestBody Cargo cargo) {
        Cargo savedCargo = cargoService.save(cargo);
        return new ResponseEntity<>(savedCargo, HttpStatus.CREATED);
    }
    // Endpoint para obtener todas los cargos
    @GetMapping
    public ResponseEntity<List<Cargo>> getAllCargos() {
        List<Cargo> cargos = cargoService.findAll();
        return new ResponseEntity<>(cargos, HttpStatus.OK);
    }
    // Endpoint para obtener un cargo
    @GetMapping("/{id}")
    public ResponseEntity<Cargo> getCargoById(@PathVariable Integer id) {
        Cargo cargo = cargoService.findById(id);
        if (cargo != null) {
            return new ResponseEntity<>(cargo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    // Endpoint para actualizar un cargo
    @PutMapping("/{id}")
    public ResponseEntity<Cargo> updateCargo(@PathVariable Integer id, @RequestBody Cargo cargoDetails) {
        Cargo existingCargo = cargoService.findById(id);
        if (existingCargo != null) {
            cargoDetails.setIdCargo(id);
            Cargo updatedCargo = cargoService.update(cargoDetails);
            return new ResponseEntity<>(updatedCargo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    // Endpoint para eliminar un cargo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCargo(@PathVariable Integer id) {
        Cargo cargo = cargoService.findById(id);
        if (cargo != null) {
            cargoService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
