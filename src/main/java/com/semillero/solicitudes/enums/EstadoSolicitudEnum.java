package com.semillero.solicitudes.enums;

public enum EstadoSolicitudEnum {
    PENDIENTE("Pendiente"),
    APROBADA("Aprobada"),
    RECHAZADA("Rechazada");

    private final String descripcion;

    EstadoSolicitudEnum(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
