package com.ricardo.model;

import java.util.ArrayList;
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
/**
 *
 * @author ricardo
 */
@Entity
@Table(name="Equipos")
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "equipo_id")
    private int id;
    private String imei;
    private String codigosap;
    private String tipoingreso;
    private String observacion;
    private String estado;
    //MUCHOS EQUIPOS TIENE UN SOLO MODELO
    @ManyToOne
    @JoinColumn(name="modelo_id")
    private Modelo modelo;

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }
    
    //MUCHOS EQUIPOS TIENE UN SOLO BODEGA
    @ManyToOne
    @JoinColumn(name="bodega_id")
    private Bodega bodega;

    public Bodega getBodega() {
        return bodega;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }
    //MUCHOS EQUIPOS TIENE UN SOLO RECEPCION
    /*@ManyToOne
    @JoinColumn(name="recepcion_id")
    private Recepcion recepcion;

    public Recepcion getRecepcion() {
        return recepcion;
    }

    public void setRecepcion(Recepcion recepcion) {
        this.recepcion = recepcion;
    }
*/
    public Equipo() {
    }

    public Equipo(int id, String imei, String codigosap, String tipoingreso, String observacion, String estado) {
        this.id = id;
        this.imei = imei;
        this.codigosap = codigosap;
        this.tipoingreso = tipoingreso;
        this.observacion = observacion;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getCodigosap() {
        return codigosap;
    }

    public void setCodigosap(String codigosap) {
        this.codigosap = codigosap;
    }

    public String getTipoingreso() {
        return tipoingreso;
    }

    public void setTipoingreso(String tipoingreso) {
        this.tipoingreso = tipoingreso;
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
   
    /*@ManyToOne
    @JoinColumn(name="recepciondetalle_id")
    private RecepcionDetalle recepciondetalle;

    public RecepcionDetalle getRecepciondetalle() {
        return recepciondetalle;
    }

    public void setRecepciondetalle(RecepcionDetalle recepciondetalle) {
        this.recepciondetalle = recepciondetalle;
    }*/
    

}
