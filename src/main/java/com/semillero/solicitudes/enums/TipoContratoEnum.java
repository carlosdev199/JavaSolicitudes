package com.semillero.solicitudes.enums;

public enum TipoContratoEnum {
    INDEFINIDO("Indefinido"),
    TERMINO_FIJO("Término Fijo"),
    OBRA_LABOR("Obra o Labor"),
    APRENDIZAJE("Aprendizaje");

    private final String descripcion;

    TipoContratoEnum(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
