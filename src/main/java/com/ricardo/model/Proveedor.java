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
@Table(name="Proveedores")
public class Proveedor{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "proveedor_id")
    private int id;
    private String nombre;
    private String rut;
    private String telefono;
    private String celular;
    private String direccion;
    private String correo;
    private String estado;
    //UN PROVEEDOR TIENE MUCHOS RECEPCIONES
    @OneToMany(mappedBy = "proveedor")
    private List<Recepcion> recepcion = new ArrayList<Recepcion>();

    public List<Recepcion> getRecepcion() {
        return recepcion;
    }

    public void setRecepcion(List<Recepcion> recepcion) {
        this.recepcion = recepcion;
    }
    
    public Proveedor() {
    }

    public Proveedor(int id, String nombre, String rut, String telefono, String celular, String direccion, String correo, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.rut = rut;
        this.telefono = telefono;
        this.celular = celular;
        this.direccion = direccion;
        this.correo = correo;
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

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
            
    
}
