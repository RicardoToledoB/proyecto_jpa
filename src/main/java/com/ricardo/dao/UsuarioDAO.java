/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ricardo.dao;

import com.ricardo.model.Rol;
import com.ricardo.model.Usuario;
import java.util.List;

/**
 *
 * @author ricardo
 */
public interface UsuarioDAO {
    public void save(Usuario user);
    public void delete(Usuario user);
    public List<Usuario> findAll();
    public void edit(Usuario user);
}
