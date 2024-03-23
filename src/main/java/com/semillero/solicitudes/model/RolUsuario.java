package com.semillero.solicitudes.model;


import com.semillero.solicitudes.enums.RolUsuarioEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "rol_usuario")
public class RolUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nm_id_rol")
    private Integer IdRol;
    @Enumerated(EnumType.STRING)
    @Column(name = "ds_rol", length = 30)
    private RolUsuarioEnum Rol;

    @Column(name = "fe_fecha_creacion")
    private LocalDate feFechaCreacion;

    public RolUsuario(Integer idRol, RolUsuarioEnum rol, LocalDate feFechaCreacion) {
        IdRol = idRol;
        Rol = rol;
        this.feFechaCreacion = feFechaCreacion;
    }

    public Integer getIdRol() {
        return IdRol;
    }

    public void setIdRol(Integer idRol) {
        IdRol = idRol;
    }

    public RolUsuarioEnum getRol() {
        return Rol;
    }

    public void setRol(RolUsuarioEnum rol) {
        Rol = rol;
    }

    public LocalDate getFeFechaCreacion() {
        return feFechaCreacion;
    }

    public void setFeFechaCreacion(LocalDate feFechaCreacion) {
        this.feFechaCreacion = feFechaCreacion;
    }
}
