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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ricardo
 */
@Entity
@Table(name = "Menus")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "menu_id")
    private int id;
    private String nombre;
    private String icon;
    private String url;
    private String estado;
    //UN MENU TIENE MUCHOS SUB MENUS
    @OneToMany(mappedBy = "menu")
    private List<SubMenu> submenu = new ArrayList<SubMenu>();

    public List<SubMenu> getSubmenu() {
        return submenu;
    }

    public void setSubmenu(List<SubMenu> submenu) {
        this.submenu = submenu;
    }

    public Menu() {
    }

    public Menu(int id, String nombre, String icon, String url, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.icon = icon;
        this.url = url;
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    ///////////////////////////////////////
    //UN MENU PUEDE TENER MUCHOS ROLES Y MUCHOS ROLES PUEDEN TENER MUCHOS MENUS
    @ManyToMany(mappedBy = "menus")
    public List<Rol> roles = new ArrayList<Rol>();
    public List<Rol> getRoles() {
        return roles;
    }
    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

}
