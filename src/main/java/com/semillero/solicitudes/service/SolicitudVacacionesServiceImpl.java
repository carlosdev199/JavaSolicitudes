package com.semillero.solicitudes.service;

import com.semillero.solicitudes.model.SolicitudVacaciones;
import com.semillero.solicitudes.repository.SolicitudVacaionesRepository;

import java.util.List;

public class SolicitudVacacionesServiceImpl implements SolicitudVacacionesService{

    private final SolicitudVacaionesRepository solicitudVacaionesRepository;
    public SolicitudVacacionesServiceImpl(SolicitudVacaionesRepository solicitudVacaionesRepository) {
        this.solicitudVacaionesRepository = solicitudVacaionesRepository;
    }

    @Override
    public SolicitudVacaciones save(SolicitudVacaciones solicitudVacaciones) {
        return solicitudVacaionesRepository.save(solicitudVacaciones);
    }

    @Override
    public List<SolicitudVacaciones> findAll() {
        return null;
    }

    @Override
    public SolicitudVacaciones findById(Integer id) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public SolicitudVacaciones update(SolicitudVacaciones solicitudVacaciones) {
        return null;
    }
}
