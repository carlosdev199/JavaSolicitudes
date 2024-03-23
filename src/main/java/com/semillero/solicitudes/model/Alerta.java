package com.semillero.solicitudes.model;

import com.semillero.solicitudes.enums.EstadoAlertaEnum;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Alerta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nm_id_alerta")
    private Integer IdAlerta;

    @Column(name = "ds_asunto", length = 20)
    private String asunto;

    @Column(name = "ds_destinatario", length = 40)
    private String destinatario;

    @Column(name = "ds_contenido_alerta", length = 40)
    private String contenidoAlerta;

    @Enumerated(EnumType.STRING)
    @Column(name = "ds_estado_alerta", length = 10)
    private EstadoAlertaEnum estadoAlerta;

    @Column(name = "fe_fecha_creacion")
    private LocalDate fechaCreacion;


    // Constructores
    public Alerta(Integer idAlerta, String asunto, String destinatario, String contenidoAlerta,
                  EstadoAlertaEnum estadoAlerta, LocalDate fechaCreacion) {
        IdAlerta = idAlerta;
        this.asunto = asunto;
        this.destinatario = destinatario;
        this.contenidoAlerta = contenidoAlerta;
        this.estadoAlerta = estadoAlerta;
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getIdAlerta() {
        return IdAlerta;
    }
    // Métodos getters y setters
    public void setIdAlerta(Integer idAlerta) {
        IdAlerta = idAlerta;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getContenidoAlerta() {
        return contenidoAlerta;
    }

    public void setContenidoAlerta(String contenidoAlerta) {
        this.contenidoAlerta = contenidoAlerta;
    }

    public EstadoAlertaEnum getEstadoAlerta() {
        return estadoAlerta;
    }

    public void setEstadoAlerta(EstadoAlertaEnum estadoAlerta) {
        this.estadoAlerta = estadoAlerta;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}