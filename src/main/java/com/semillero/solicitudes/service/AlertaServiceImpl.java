package com.semillero.solicitudes.service;

import com.semillero.solicitudes.model.Alerta;
import com.semillero.solicitudes.model.Empleado;
import com.semillero.solicitudes.repository.AlertaRepository;
import com.semillero.solicitudes.repository.EmpleadoRepository;

import java.util.List;

public class AlertaServiceImpl implements AlertaService {
    private final AlertaRepository alertaRepository;

    public AlertaServiceImpl(AlertaRepository alertaRepository) {
        this.alertaRepository = alertaRepository;
    }

    @Override
    public Alerta save(Alerta alerta) {
        return alertaRepository.save(alerta);
    }

    @Override
    public List<Alerta> findAll() {
        return null;
    }

    @Override
    public Alerta findById(Integer id) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Alerta update(Alerta alerta) {
        return null;
    }
}
