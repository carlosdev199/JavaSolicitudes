package com.semillero.solicitudes.enums;

public enum TipoDocumentoEnum {
    CEDULA_CIUDADANIA("Cédula de Ciudadanía"),
    TARJETA_IDENTIDAD("Tarjeta de Identidad"),
    CEDULA_EXTRANJERIA("Cédula de Extranjería"),
    PASAPORTE("Pasaporte");

    private final String descripcion;

    TipoDocumentoEnum(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }


}