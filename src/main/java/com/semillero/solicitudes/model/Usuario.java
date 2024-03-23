package com.semillero.solicitudes.model;

import jakarta.persistence.*;


import java.time.LocalDate;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nm_id_usuario")
    private Integer IdUsuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nm_id_empelado")
    private Empleado IdEmpleado;

    @Column(name = "ds_usuario", length = 100)
    private String usuario;

    @Column(name = "fe_fecha_creacion")
    private LocalDate feFechaCreacion;

    @Column(name = "ds_activo", length = 10)
    private String activo;

    @Column(name = "ds_contraseña", length = 100)
    private String contraseña;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nm_rol")
    private RolUsuario rol;

    public Usuario() {
    }

    public Usuario(Integer idUsuario, Empleado idEmpleado, String usuario, LocalDate feFechaCreacion, String activo,
                   String contraseña, RolUsuario rol) {
        IdUsuario = idUsuario;
        IdEmpleado = idEmpleado;
        this.usuario = usuario;
        this.feFechaCreacion = feFechaCreacion;
        this.activo = activo;
        this.contraseña = contraseña;
        this.rol = rol;
    }

    public Integer getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        IdUsuario = idUsuario;
    }

    public Empleado getIdEmpleado() {
        return IdEmpleado;
    }

    public void setIdEmpleado(Empleado idEmpleado) {
        IdEmpleado = idEmpleado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public LocalDate getFeFechaCreacion() {
        return feFechaCreacion;
    }

    public void setFeFechaCreacion(LocalDate feFechaCreacion) {
        this.feFechaCreacion = feFechaCreacion;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public RolUsuario getRol() {
        return rol;
    }

    public void setRol(RolUsuario rol) {
        this.rol = rol;
    }
}
