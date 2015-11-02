/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ricardo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ricardo
 */
@Entity
@Table(name="Solicitudes")
public class Solicitud {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "solicitud_id")
    private int id;
    @Temporal(TemporalType.DATE)
    private Date fechasolicitud;
    private String sim;
    private String sstm;
    private String pcs;
    private String observacion;
    private String estado;
    //MUCHOS Solicitudes TIENE UN SOLO equipo
    @ManyToOne
    @JoinColumn(name="equipo_id")
    private Equipo equipo;

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
    //MUCHOS Solicitudes TIENE UN SOLO plan
    @ManyToOne
    @JoinColumn(name="plan_id")
    private Plan plan;

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }
    //MUCHOS Solicitudes TIENE UN SOLO usuario responsable
    @ManyToOne
    @JoinColumn(name="usuario_id")
    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
     //MUCHOS Solicitudes TIENE UN SOLO cliente quien solicita
    @ManyToOne
    @JoinColumn(name="cliente_id")
    private Cliente cliente;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Solicitud() {
    }

    public Solicitud(int id, Date fechasolicitud, String sim, String sstm, String pcs, String observacion, String estado) {
        this.id = id;
        this.fechasolicitud = fechasolicitud;
        this.sim = sim;
        this.sstm = sstm;
        this.pcs = pcs;
        this.observacion = observacion;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechasolicitud() {
        return fechasolicitud;
    }

    public void setFechasolicitud(Date fechasolicitud) {
        this.fechasolicitud = fechasolicitud;
    }

    public String getSim() {
        return sim;
    }

    public void setSim(String sim) {
        this.sim = sim;
    }

    public String getSstm() {
        return sstm;
    }

    public void setSstm(String sstm) {
        this.sstm = sstm;
    }

    public String getPcs() {
        return pcs;
    }

    public void setPcs(String pcs) {
        this.pcs = pcs;
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
    
    //UN Solicitud TIENE MUCHOS Rechazos
    @OneToMany(mappedBy = "solicitud")
    private List<Rechazo> rechazos = new ArrayList<Rechazo>();

    public List<Rechazo> getRechazos() {
        return rechazos;
    }

    public void setRechazos(List<Rechazo> rechazos) {
        this.rechazos = rechazos;
    }
    
    //UN Solicitud TIENE MUCHOS Aprobados
    @OneToMany(mappedBy = "solicitud")
    private List<Aprobado> aprobados = new ArrayList<Aprobado>();

    public List<Aprobado> getAprobados() {
        return aprobados;
    }

    public void setAprobados(List<Aprobado> aprobados) {
        this.aprobados = aprobados;
    }
    
    

}
