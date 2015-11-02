/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ricardo
 */
@Entity
@Table(name="Rechazos")
public class Rechazo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rechazo_id")
    private int id;
    @Temporal(TemporalType.DATE)
    private Date fecharechazo;
    private String observacion;
    private String estado;
    //MUCHOS RECHAZO TIENE UN SOLO Usuario responsable
    @ManyToOne
    @JoinColumn(name="usuario_id")
    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    //MUCHOS RECHAZO TIENE UN SOLO SOLICITUD
    @ManyToOne
    @JoinColumn(name="solicitud_id")
    private Solicitud solicitud;

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }

    public Rechazo() {
    }

    public Rechazo(int id, Date fecharechazo, String observacion, String estado) {
        this.id = id;
        this.fecharechazo = fecharechazo;
        this.observacion = observacion;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecharechazo() {
        return fecharechazo;
    }

    public void setFecharechazo(Date fecharechazo) {
        this.fecharechazo = fecharechazo;
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
