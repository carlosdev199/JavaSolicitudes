package com.semillero.solicitudes.model;

import com.semillero.solicitudes.enums.EstadoSolicitudEnum;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "solicitud_vacaciones")
public class SolicitudVacaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nm_id_solicitud")
    private Integer IdSolicitud;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nm_id_usuario")
    private Usuario IdUsuario;

    @Column(name = "nm_dias_solicita")
    private int diasSolicita;

    @Column(name = "fe_fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name = "fe_fecha_fin")
    private LocalDate fechaFin;

    @Column(name = "fe_fecha_retorna")
    private LocalDate fechaRetorna;

    @Enumerated(EnumType.STRING)
    @Column(name = "ds_estado", length = 10)
    private EstadoSolicitudEnum estado;

    @Column(name = "ds_observaciones", length = 60)
    private String oservaciones;

    @Column(name = "fe_fecha_creacion")
    private LocalDate fechaCreacion;

    // Constructores
    public SolicitudVacaciones(Integer idSolicitud, Usuario idUsuario, int diasSolicita, LocalDate fechaInicio, LocalDate fechaFin, LocalDate fechaRetorna, EstadoSolicitudEnum estado, String oservaciones,
                               LocalDate fechaCreacion) {
        IdSolicitud = idSolicitud;
        IdUsuario = idUsuario;
        this.diasSolicita = diasSolicita;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.fechaRetorna = fechaRetorna;
        this.estado = estado;
        this.oservaciones = oservaciones;
        this.fechaCreacion = fechaCreacion;
    }

    // Métodos getters y setters
    public Integer getIdSolicitud() {
        return IdSolicitud;
    }

    public void setIdSolicitud(Integer idSolicitud) {
        IdSolicitud = idSolicitud;
    }

    public Usuario getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        IdUsuario = idUsuario;
    }

    public int getDiasSolicita() {
        return diasSolicita;
    }

    public void setDiasSolicita(int diasSolicita) {
        this.diasSolicita = diasSolicita;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public LocalDate getFechaRetorna() {
        return fechaRetorna;
    }

    public void setFechaRetorna(LocalDate fechaRetorna) {
        this.fechaRetorna = fechaRetorna;
    }

    public EstadoSolicitudEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoSolicitudEnum estado) {
        this.estado = estado;
    }

    public String getOservaciones() {
        return oservaciones;
    }

    public void setOservaciones(String oservaciones) {
        this.oservaciones = oservaciones;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }


}