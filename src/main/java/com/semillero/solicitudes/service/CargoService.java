package com.semillero.solicitudes.service;

import com.semillero.solicitudes.model.Cargo;

import java.util.List;

public interface CargoService {
    Cargo save(Cargo cargo);
    List<Cargo> findAll();
    Cargo findById(Integer id);
    void deleteById(Integer id);
    Cargo update(Cargo cargo);

}
