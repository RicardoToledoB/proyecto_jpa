/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ricardo.dao;

import com.ricardo.model.Rol;
import java.util.List;

/**
 *
 * @author ricardo
 */
public interface RolDAO {
    public void save(Rol rol);
    public void delete(Rol rol);
    public List<Rol> findAll();
    public void edit(Rol rol);
}
