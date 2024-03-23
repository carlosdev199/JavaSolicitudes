package com.semillero.solicitudes.enums;

public enum RolUsuarioEnum {
    ADMINISTRADOR("Administrador"),
    EMPLEADO("Empleado"),
    SUPERVISOR("Supervisor"),
    MAESTRO_DE_EMPLEADOS("Maestro de Empleados");

    private final String descripcion;

    RolUsuarioEnum(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
