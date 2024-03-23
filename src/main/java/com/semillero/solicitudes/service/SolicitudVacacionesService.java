package com.semillero.solicitudes.service;

import com.semillero.solicitudes.model.Empleado;
import com.semillero.solicitudes.model.SolicitudVacaciones;

import java.util.List;

public interface SolicitudVacacionesService {
    SolicitudVacaciones save(SolicitudVacaciones solicitudVacaciones);
    List<SolicitudVacaciones> findAll();
    SolicitudVacaciones findById(Integer id);
    void deleteById(Integer id);
    SolicitudVacaciones update(SolicitudVacaciones solicitudVacaciones);
}
