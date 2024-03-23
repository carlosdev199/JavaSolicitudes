package com.semillero.solicitudes.model;

import com.semillero.solicitudes.enums.EstadoEmpleadoEnum;
import com.semillero.solicitudes.enums.TipoContratoEnum;
import com.semillero.solicitudes.enums.TipoDocumentoEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "Empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nm_id_empleado")
    private Integer idEmpleado;

    @Column(name = "nm_documento", unique = true)
    private Integer documentos;
    @Enumerated(EnumType.STRING)
    @Column(name = "ds_tipo_documento", length = 30)
    private TipoDocumentoEnum tipoDodumento;
    @Column(name = "ds_nombre", length=30)
    private String nombre;
    @Column(name = "ds_apellido", length=30)
    private String apellido;
    @Column(name = "ds_telefono", length=14)
    private String telefono;
    @Column(name = "ds_direccion", length= 60)
    private String direccion;
    @Column(name = "fe_fecha_ingreso")
    private LocalDate fechaIngreso;
    @Column(name = "e_fecha_retiro")
    private LocalDate fechaRetiro;
    @Enumerated(EnumType.STRING)
    @Column(name = "ds_tipo_contrato", length =20)
    private TipoContratoEnum tipoContrato;
    @Enumerated(EnumType.STRING)
    @Column(name = "ds_estado_emleado", length =10)
    private EstadoEmpleadoEnum estadoEmpleado;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nm_supervisor_inmediato", referencedColumnName = "nm_id_empleado")
    private Empleado supervisorInmediato;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nm_cargo")
    private Cargo cargo;

    // Constructores
    public Empleado(Integer idEmpleado, Integer documentos, TipoDocumentoEnum tipoDodumento, String nombre, String apellido, String telefono, String direccion, LocalDate fechaIngreso, LocalDate fechaRetiro, TipoContratoEnum tipoContrato, EstadoEmpleadoEnum estadoEmpleado,
                    Empleado supervisorInmediato, Cargo cargo) {
        this.idEmpleado = idEmpleado;
        this.documentos = documentos;
        this.tipoDodumento = tipoDodumento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fechaIngreso = fechaIngreso;
        this.fechaRetiro = fechaRetiro;
        this.tipoContrato = tipoContrato;
        this.estadoEmpleado = estadoEmpleado;
        this.supervisorInmediato = supervisorInmediato;
        this.cargo = cargo;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }
    // Métodos getters y setters
    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Integer getDocumentos() {
        return documentos;
    }

    public void setDocumentos(Integer documentos) {
        this.documentos = documentos;
    }

    public TipoDocumentoEnum getTipoDodumento() {
        return tipoDodumento;
    }

    public void setTipoDodumento(TipoDocumentoEnum tipoDodumento) {
        this.tipoDodumento = tipoDodumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LocalDate getFechaRetiro() {
        return fechaRetiro;
    }

    public void setFechaRetiro(LocalDate fechaRetiro) {
        this.fechaRetiro = fechaRetiro;
    }

    public TipoContratoEnum getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(TipoContratoEnum tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public EstadoEmpleadoEnum getEstadoEmpleado() {
        return estadoEmpleado;
    }

    public void setEstadoEmpleado(EstadoEmpleadoEnum estadoEmpleado) {
        this.estadoEmpleado = estadoEmpleado;
    }

    public Empleado getSupervisorInmediato() {
        return supervisorInmediato;
    }

    public void setSupervisorInmediato(Empleado supervisorInmediato) {
        this.supervisorInmediato = supervisorInmediato;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }


    // Método para validar si se pueden solicitar vacaciones anticipadas
    public boolean puedeSolicitarVacacionesAnticipadas() {
        // Validar si ha pasado el periodo de prueba
        LocalDate fechaInicioPrueba = this.fechaIngreso.plusMonths(2);
        if (LocalDate.now().isBefore(fechaInicioPrueba)) {
            return false; // No ha pasado el periodo de prueba
        }

        // Validar si tiene un contrato laboral vigente
        if (this.tipoContrato != TipoContratoEnum.TERMINO_FIJO) {
            return false; // No tiene un contrato laboral
        }

        return true;
    }

    // Método para validar la anticipación de la solicitud de vacaciones
    public boolean validarAnticipacionVacaciones(LocalDate fechaSolicitud) {
        LocalDate fechaMinimaSolicitud = LocalDate.now().plusDays(15);
        return fechaSolicitud.isAfter(fechaMinimaSolicitud);
    }
}