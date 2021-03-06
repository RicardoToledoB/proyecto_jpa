/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ricardo.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ricardo
 */
@Entity
@Table(name="Marcas")
public class Marca {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "marca_id")
    private int id;
    private String nombre;
    private String estado;
    //UN Marca TIENE MUCHOS Modelos
    @OneToMany(mappedBy = "marca")
    private List<Modelo> modelo = new ArrayList<Modelo>();

    public List<Modelo> getModelo() {
        return modelo;
    }

    public void setModelo(List<Modelo> modelo) {
        this.modelo = modelo;
    }

    public Marca() {
    }

    public Marca(int id, String nombre, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
