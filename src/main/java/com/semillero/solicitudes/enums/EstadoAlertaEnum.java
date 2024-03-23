package com.semillero.solicitudes.enums;

public enum EstadoAlertaEnum {
    PENDIENTE("Pendiente"),
    ENVIADA("Enviada"),
    LEIDA("Leída");

    private final String descripcion;

    EstadoAlertaEnum(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}