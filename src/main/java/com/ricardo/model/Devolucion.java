package com.ricardo.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author ricardo
 */
@Entity
@Table(name="Devoluciones")
public class Devolucion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "devolucion_id")
    private int id;
    private Date fechadevolucion;
    private String observacion;
    private String estado;
    @ManyToOne
    @JoinColumn(name="usuario_id")
    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    //MUCHOS Devoluciones TIENE UN SOLO aprobados
    @ManyToOne
    @JoinColumn(name="aprobado_id")
    private Aprobado aprobado;

    public Aprobado getAprobado() {
        return aprobado;
    }

    public void setAprobado(Aprobado aprobado) {
        this.aprobado = aprobado;
    }

    public Devolucion() {
    }

    public Devolucion(int id, Date fechadevolucion, String observacion, String estado) {
        this.id = id;
        this.fechadevolucion = fechadevolucion;
        this.observacion = observacion;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechadevolucion() {
        return fechadevolucion;
    }

    public void setFechadevolucion(Date fechadevolucion) {
        this.fechadevolucion = fechadevolucion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
