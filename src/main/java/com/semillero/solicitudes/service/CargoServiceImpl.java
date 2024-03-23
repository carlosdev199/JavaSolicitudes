package com.semillero.solicitudes.service;

import com.semillero.solicitudes.model.Cargo;
import com.semillero.solicitudes.repository.CargoRepository;
import com.semillero.solicitudes.repository.EmpleadoRepository;

import java.util.List;

public class CargoServiceImpl implements CargoService{

    private final CargoRepository cargoRepository;

    public CargoServiceImpl(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    @Override
    public Cargo save(Cargo cargo) {
        return cargoRepository.save(cargo);
    }

    @Override
    public List<Cargo> findAll() {
        return null;
    }

    @Override
    public Cargo findById(Integer id) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Cargo update(Cargo cargo) {
        return null;
    }
}
