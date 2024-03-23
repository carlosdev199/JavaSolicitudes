package com.semillero.solicitudes.service;

import com.semillero.solicitudes.model.Empleado;
import com.semillero.solicitudes.repository.EmpleadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmpleadoServiceImpl implements EmpleadoService{

    private final EmpleadoRepository empleadoRepository;

    public EmpleadoServiceImpl(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    @Override
    public Empleado save(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public List<Empleado> findAll() {
        return null;
    }

    @Override
    public Empleado findById(Integer id) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Empleado update(Empleado empleado) {
        return null;
    }
}
