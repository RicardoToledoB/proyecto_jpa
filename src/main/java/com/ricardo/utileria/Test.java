/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ricardo.utileria;


import com.ricardo.dao.RolDAO;
import com.ricardo.dao.RolDAOImpl;
import com.ricardo.dao.UsuarioDAOImpl;
import com.ricardo.model.Rol;
import com.ricardo.model.Usuario;

/**
 *
 * @author ricardo
 */
public class Test {
    public static void main(String[] args){
        
        Usuario user=new Usuario();
        user.setUsername("PETER");
        user.setPassword("123456");
        user.setEstado("ACTIVO");
        UsuarioDAOImpl uDAO=new UsuarioDAOImpl();
        uDAO.save(user);
        
        
        /*
        Rol rol=new Rol();
        rol.setTipo("EJECUTIVO");
        rol.setEstado("ACTIVO");
        RolDAO rDAO=new RolDAOImpl();
        rDAO.save(rol);
        */
        
        /*
        UsuarioDAOImpl uDAO=new UsuarioDAOImpl();
        Usuario user=uDAO.findById(251);
        RolDAOImpl rDAO=new RolDAOImpl();
        Rol roles=rDAO.findById(201);
        user.getRoles().add(roles);
        uDAO.edit(user);
        */
        
    }
}
