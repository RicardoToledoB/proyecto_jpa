
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
@Table(name="Aprobados")
public class Aprobado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "aprobado_id")
    private int id;
    @Temporal(TemporalType.DATE)
    private Date fechaaprobacion;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaaprobacion() {
        return fechaaprobacion;
    }

    public void setFechaaprobacion(Date fechaaprobacion) {
        this.fechaaprobacion = fechaaprobacion;
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
    
       //UN AprobadoTIENE MUCHOS devoluciones
    @OneToMany(mappedBy = "aprobado")
    private List<Devolucion> devoluciones = new ArrayList<Devolucion>();

    public List<Devolucion> getDevoluciones() {
        return devoluciones;
    }

    public void setDevoluciones(List<Devolucion> devoluciones) {
        this.devoluciones = devoluciones;
    }
    

    
}
