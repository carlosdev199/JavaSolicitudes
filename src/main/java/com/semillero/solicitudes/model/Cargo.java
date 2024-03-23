package com.semillero.solicitudes.model;


import jakarta.persistence.Entity;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "cargo")
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nm_id_cargo")
    private Integer IdCargo;
    @Column(name = "ds_cargo", length = 50)
    private String cargo;
    @Column(name = "ds_descripcion", length = 100)
    private String descripcion;
    @Column(name = "fe_fecha_creacion")
    private LocalDate fechaCreacion;
    @Column(name = "ds_activo", length = 10)
    private String activo;

    public Cargo() {
    }

    public Cargo(Integer idCargo, String cargo, String descripcion, LocalDate fechaCreacion, String activo) {
        IdCargo = idCargo;
        this.cargo = cargo;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.activo = activo;
    }

    public Integer getIdCargo() {
        return IdCargo;
    }

    public void setIdCargo(Integer idCargo) {
        IdCargo = idCargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

}

