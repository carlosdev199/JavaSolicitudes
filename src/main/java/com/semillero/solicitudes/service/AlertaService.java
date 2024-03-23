package com.semillero.solicitudes.service;

import com.semillero.solicitudes.model.Alerta;
import com.semillero.solicitudes.model.Empleado;

import java.util.List;

public interface AlertaService {
    Alerta save(Alerta alerta);
    List<Alerta> findAll();
    Alerta findById(Integer id);
    void deleteById(Integer id);
    Alerta update(Alerta alerta);
}
