package com.semillero.solicitudes.enums;

    public enum EstadoEmpleadoEnum {
        ACTIVO("Activo"),
        INACTIVO("Inactivo"),
        LICENCIA("Licencia"),
        DESPEDIDO("Despedido");

        private final String descripcion;

        EstadoEmpleadoEnum(String descripcion) {
            this.descripcion = descripcion;
        }

        public String getDescripcion() {
            return descripcion;
        }
}
