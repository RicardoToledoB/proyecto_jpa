package com.ricardo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ricardo
 */
@Entity
@Table(name="RecepcionesDetalles")
public class RecepcionDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "recepciondetalle_id")
    private int id;
    @ManyToOne
    @JoinColumn(name="recepcion_id")
    private Recepcion recepcion;

    public Recepcion getRecepcion() {
        return recepcion;
    }

    public void setRecepcion(Recepcion recepcion) {
        this.recepcion = recepcion;
    }
    @ManyToOne
    @JoinColumn(name="equipo_id")
    private Equipo equipo;

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
    
  
    public RecepcionDetalle() {
    }

    public RecepcionDetalle(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
