/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ricardo.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author ricardo
 */
@Entity
@Table(name = "Usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "usuario_id")
    private int id;
    private String username;
    private String password;
    private String estado;

    public Usuario() {
    }

    public Usuario(int id, String username, String password, String estado) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "Usuarios_Roles",
            joinColumns = {
                @JoinColumn(name = "usuario_id")
            },
            inverseJoinColumns = {
                @JoinColumn(name = "rol_id")
            })
    private List<Rol> roles = new ArrayList<Rol>();

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }
    //UN Usuario TIENE MUCHOS Recepciones
    @OneToMany(mappedBy = "usuario")
    private List<Recepcion> recepcion = new ArrayList<Recepcion>();

    public List<Recepcion> getRecepcion() {
        return recepcion;
    }

    public void setRecepcion(List<Recepcion> recepcion) {
        this.recepcion = recepcion;
    }
    
}
