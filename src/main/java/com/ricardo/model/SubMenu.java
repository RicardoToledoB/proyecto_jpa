/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ricardo.model;

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
@Table(name="SubMenus")
public class SubMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="submenu_id")
    private int id;
    private String nombre;
    private String icon;
    private String url;
    private String estado;
    
    //MUCHOS MENUS TIENE UN SOLO MENU
    @ManyToOne
    @JoinColumn(name="menu_id")
    private Menu menu;

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
    
    
    
    public SubMenu() {
    }

    public SubMenu(int id, String nombre, String icon, String url, String estado) {
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
    

}
